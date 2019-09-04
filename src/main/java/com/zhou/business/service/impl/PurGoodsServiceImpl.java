package com.zhou.business.service.impl;

import com.zhou.business.common.api.AbstractResultBase;
import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.dal.toolmall.entity.PurGoods;
import com.zhou.business.dal.toolmall.entity.PurGoodsBrand;
import com.zhou.business.dal.toolmall.entity.PurGoodsCategory;
import com.zhou.business.dal.toolmall.entity.PurGoodsSpec;
import com.zhou.business.dal.toolmall.mapper.PurGoodsMapper;
import com.zhou.business.result.PurGoodsOperateResult;
import com.zhou.business.service.PurGoodsBrandService;
import com.zhou.business.service.PurGoodsCategoryService;
import com.zhou.business.service.PurGoodsService;
import com.zhou.business.service.PurGoodsSpecService;
import com.zhou.business.util.ListUtils;
import com.zhou.business.util.StringUtils;
import com.zhou.business.wdtclient.WdtApiIntegration;
import com.zhou.business.wdtclient.model.WdtGoodsPushInfo;
import com.zhou.business.wdtclient.model.WdtGoodsSpecPushInfo;
import com.zhou.business.wdtclient.result.WdtBaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 18:43
 */
@Service
public class PurGoodsServiceImpl implements PurGoodsService {

    @Value("${sqlServer.parameterCount}")
    private int parameterCount;

    @Autowired
    private PurGoodsMapper purGoodsMapper;

    @Autowired
    private PurGoodsSpecService purGoodsSpecService;

    @Autowired
    private PurGoodsBrandService purGoodsBrandService;

    @Autowired
    private PurGoodsCategoryService purGoodsCategoryService;

//    @Autowired
//    private TransactionTemplate transactionTemplate;

    @Autowired
    private WdtApiIntegration wdtApiIntegration;

    @Override
    public void batchSave(List<PurGoods> purGoodsList) {
        if(purGoodsList.size()==0){
            return ;
        }
        List<List<PurGoods>> averageList = ListUtils.part(purGoodsList, parameterCount/PurGoods.class.getDeclaredFields().length);
        for (final List<PurGoods> eachList : averageList) {
            if (eachList == null || eachList.size() == 0) {
                continue;
            }
            purGoodsMapper.batchSave(eachList);
        }
        return ;
    }

    @Override
    public PurGoodsOperateResult create(PurGoods purGoods) {
        PurGoodsOperateResult result = new PurGoodsOperateResult();
        if(StringUtils.isEmpty(purGoods.getGoodsNo())){
            result.setSuccess(false);
            result.setDetailMessage("货品编号不能为空");
            return result;
        }
        if(StringUtils.notEmpty(purGoods.getBrandName())){
            PurGoodsBrand purGoodsBrand = purGoodsBrandService.getByBrandName(purGoods.getBrandName());
            if(purGoodsBrand == null){
                result.setSuccess(false);
                result.setDetailMessage(purGoods.getBrandName()+"品牌不存在");
                return result;
            }
        }
        if(StringUtils.notEmpty(purGoods.getClassName())){
            PurGoodsCategory purGoodsCategory = purGoodsCategoryService.getByCode(purGoods.getClassName());
            if(purGoodsCategory == null){
                result.setSuccess(false);
                result.setDetailMessage(purGoods.getClassName()+"分类不存在");
                return result;
            }else if(purGoodsCategory.getType() != 2){
                result.setSuccess(false);
                result.setDetailMessage(purGoods.getClassName()+"不是分类级别");
                return result;
            }
        }
        PurGoods existPurGoods = purGoodsMapper.selectByGoodsNoAndEnabled(purGoods.getGoodsNo(),null);
        if(existPurGoods != null ){
            if(existPurGoods.isEnabled()){
                purGoods.setEnabled(true);
                purGoods.setId(existPurGoods.getId());
                purGoodsMapper.updateByPrimaryKeySelective(purGoods);
            }else{
                result.setSuccess(false);
                result.setDetailMessage("该"+purGoods.getGoodsNo()+"编号货品已经存在");
                return result;
            }
        }else {
            purGoodsMapper.insert(purGoods);
        }
        result.setSuccess(true);
        return result;
    }


    @Override
    @Transactional(value = "toolMallTransactionManager", rollbackFor = { Exception.class })
    public PurGoodsOperateResult batchCreate(List<PurGoods> purGoodsList) {
        PurGoodsOperateResult result = new PurGoodsOperateResult();
        result.setSuccess(true);
        for(PurGoods purGoods : purGoodsList){
            PurGoodsOperateResult purGoodsOperateResult = create(purGoods);
            if(!purGoodsOperateResult.isSuccess()){
                result.setSuccess(false);
                result.setDetailMessage(purGoodsOperateResult.getDetailMessage());
                return result;
            }
        }
        return result;
    }

    @Override
    @Transactional(value = "toolMallTransactionManager", rollbackFor = { Exception.class })
    public AbstractResultBase stuffGoods(List<ProductDs> productDsList) {
        AbstractResultBase abstractResultBase = new AbstractResultBase();
        List<PurGoods> purGoodsList = new ArrayList<>();
        List<PurGoodsSpec> purGoodsSpecList = new ArrayList<>();
        Map<String,List<PurGoodsSpec>> goodsSpecMap = new HashMap<>();


        batchSave(purGoodsList);
        purGoodsSpecService.batchSave(purGoodsSpecList);

        // 将商品推送到旺店通
        AbstractResultBase resultBase = goodsBatchPushToWdt(purGoodsList,goodsSpecMap);
        if(!resultBase.isSuccess()){
            abstractResultBase.setSuccess(false);
            abstractResultBase.setDetailMessage(resultBase.getDetailMessage());
            return abstractResultBase;
        }

        return abstractResultBase;
    }

    /**
     * 商品批量推送至旺店通
     * @param purGoodsList
     * @param goodsSpecMap
     * @return
     */
    public AbstractResultBase goodsBatchPushToWdt(List<PurGoods> purGoodsList, Map<String,List<PurGoodsSpec>> goodsSpecMap){
        AbstractResultBase abstractResultBase = new AbstractResultBase();
        List<WdtGoodsPushInfo> wdtGoodsPushInfoList = new ArrayList<>();
        for (PurGoods purGoods : purGoodsList) {
            wdtGoodsPushInfoList.add(convert(purGoods,goodsSpecMap.get(purGoods.getGoodsNo())));
        }
        if(wdtGoodsPushInfoList.size()>0){
            WdtBaseResult wdtBaseResult = null;
            try {
                // 批量推送，goods_list不大于100条，goods_list下的spec_list条数不能超过2000条
                List<List<WdtGoodsPushInfo>> averageList = ListUtils.part(wdtGoodsPushInfoList, 100);
                for (final List<WdtGoodsPushInfo> eachList : averageList) {
                    if (eachList == null || eachList.size() == 0) {
                        continue;
                    }
                    wdtBaseResult = wdtApiIntegration.goodsPush(eachList);
                    if(!wdtBaseResult.isSuccess()) {
                        abstractResultBase.setDetailMessage(abstractResultBase.getDetailMessage() + wdtBaseResult.getMessage());
                        abstractResultBase.setSuccess(false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                abstractResultBase.setSuccess(false);
            }
        }
        return abstractResultBase;
    }

    public WdtGoodsPushInfo convert(PurGoods purGoods, List<PurGoodsSpec> purGoodsSpecList){
        WdtGoodsPushInfo wdtGoodsPushInfo = new WdtGoodsPushInfo();
        if(purGoods != null){
            wdtGoodsPushInfo.setUnit_name(purGoods.getUnitName());
            wdtGoodsPushInfo.setShort_name(purGoods.getShortName());
            wdtGoodsPushInfo.setRemark(purGoods.getRemark());
            wdtGoodsPushInfo.setPinyin(purGoods.getPinyin());
            wdtGoodsPushInfo.setOrigin(purGoods.getOrigin());
            wdtGoodsPushInfo.setGoods_type(purGoods.getGoodsType());
            wdtGoodsPushInfo.setGoods_no(purGoods.getGoodsNo());
            wdtGoodsPushInfo.setGoods_name(purGoods.getGoodsName());
            wdtGoodsPushInfo.setClass_name(purGoods.getClassName());
            wdtGoodsPushInfo.setBrand_name(purGoods.getBrandName());
            wdtGoodsPushInfo.setAlias(purGoods.getAlias());
            wdtGoodsPushInfo.setProps1(purGoods.getProps1());
            wdtGoodsPushInfo.setProps2(purGoods.getProps2());
            wdtGoodsPushInfo.setProps3(purGoods.getProps3());
            wdtGoodsPushInfo.setProps4(purGoods.getProps4());
            wdtGoodsPushInfo.setProps5(purGoods.getProps5());
            wdtGoodsPushInfo.setProps6(purGoods.getProps6());
        }
        List<WdtGoodsSpecPushInfo> spec_list = new ArrayList<>();
        for(PurGoodsSpec purGoodsSpec : purGoodsSpecList){
            WdtGoodsSpecPushInfo wdtGoodsSpecPushInfo = new WdtGoodsSpecPushInfo();
            wdtGoodsSpecPushInfo.setBarcode(purGoodsSpec.getBarcode());
            wdtGoodsSpecPushInfo.setHeight(purGoodsSpec.getHeight());
            wdtGoodsSpecPushInfo.setIs_allow_neg_stock(purGoodsSpec.getIsAllowNegStock());
            wdtGoodsSpecPushInfo.setLowest_price(purGoodsSpec.getLowestPrice());
            wdtGoodsSpecPushInfo.setLength(purGoodsSpec.getLength());
            wdtGoodsSpecPushInfo.setMember_price(purGoodsSpec.getMemberPrice());
            wdtGoodsSpecPushInfo.setMarket_price(purGoodsSpec.getMarketPrice());
            wdtGoodsSpecPushInfo.setPick_score(BigDecimal.valueOf(purGoodsSpec.getPickScore()==null?0:purGoodsSpec.getPickScore()));
            wdtGoodsSpecPushInfo.setPack_score(BigDecimal.valueOf(purGoodsSpec.getPackScore()==null?0:purGoodsSpec.getPackScore()));
            wdtGoodsSpecPushInfo.setProp1(purGoodsSpec.getProp1());
            wdtGoodsSpecPushInfo.setProp2(purGoodsSpec.getProp2());
            wdtGoodsSpecPushInfo.setProp3(purGoodsSpec.getProp3());
            wdtGoodsSpecPushInfo.setProp4(purGoodsSpec.getProp4());
            wdtGoodsSpecPushInfo.setProp5(purGoodsSpec.getProp5());
            wdtGoodsSpecPushInfo.setProp6(purGoodsSpec.getProp6());
            wdtGoodsSpecPushInfo.setRetail_price(purGoodsSpec.getRetailPrice());
            wdtGoodsSpecPushInfo.setRemark(purGoodsSpec.getRemark());
            wdtGoodsSpecPushInfo.setSpec_code(purGoodsSpec.getSpecCode());
            wdtGoodsSpecPushInfo.setSale_score(BigDecimal.valueOf(purGoodsSpec.getSaleScore()==null?0:purGoodsSpec.getSaleScore()));
            wdtGoodsSpecPushInfo.setSpec_name(purGoodsSpec.getSpecName());
            wdtGoodsSpecPushInfo.setSpec_no(purGoodsSpec.getSpecNo());
            wdtGoodsSpecPushInfo.setSpec_unit_name(purGoodsSpec.getSpecUnitName());
            wdtGoodsSpecPushInfo.setTax_rate(purGoodsSpec.getTaxRate());
            wdtGoodsSpecPushInfo.setValidity_days(purGoodsSpec.getValidityDays()==null?0:purGoodsSpec.getValidityDays());
            wdtGoodsSpecPushInfo.setWeight(purGoodsSpec.getWeight());
            wdtGoodsSpecPushInfo.setWholesale_price(purGoodsSpec.getWholesalePrice());
            wdtGoodsSpecPushInfo.setWidth(purGoodsSpec.getWidth());
            spec_list.add(wdtGoodsSpecPushInfo);
        }
        wdtGoodsPushInfo.setSpec_list(spec_list);
        return wdtGoodsPushInfo;
    }



}
