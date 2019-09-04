package com.zhou.business.service.impl;

import com.zhou.business.common.api.AbstractResultBase;
import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.dal.business.mapper.ProductDsMapper;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.ProductDsService;
import com.zhou.business.util.ListUtils;
import com.zhou.business.wdtclient.WdtApiIntegration;
import com.zhou.business.wdtclient.model.WdtGoodsPushInfo;
import com.zhou.business.wdtclient.model.WdtGoodsSpecPushInfo;
import com.zhou.business.wdtclient.result.WdtBaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 17:48
 */
@Slf4j
@Service
public class ProductDsServiceImpl implements ProductDsService {

    @Autowired
    private ProductDsMapper productDsMapper;

    @Autowired
    private WdtApiIntegration wdtApiIntegration;

    @Override
    public List<ProductDs> getByUpdateDate(Date startTime, Date endTime) {
        return productDsMapper.selectByUpdateDate(startTime,endTime);
    }

    @Override
    public ProductDs getByProId(String proid) {
        return productDsMapper.selectByProId(proid);
    }

    @Override
    public SyncResult pushToWdt(List<ProductDs> productDsList) {
        SyncResult syncResult = new SyncResult();
        List<WdtGoodsPushInfo> wdtGoodsPushInfoList = new ArrayList<>();
        // 组装商品数据
        convert(productDsList,wdtGoodsPushInfoList,syncResult);
        // 将商品推送到旺店通
        AbstractResultBase resultBase = goodsBatchPushToWdt(wdtGoodsPushInfoList);
        if(!resultBase.isSuccess()){
            syncResult.setSuccess(false);
            syncResult.setDetailMessage(resultBase.getDetailMessage());
        }
        return syncResult;
    }


    public void convert(List<ProductDs> productDsList, List<WdtGoodsPushInfo> wdtGoodsPushInfoList, SyncResult syncResult){
        Date maxModifyDate = null;
        for(ProductDs productDs : productDsList) {
            Date modifyDate = productDs.getUpdatedate();
            if (maxModifyDate == null || modifyDate.after(maxModifyDate)) {
                maxModifyDate = modifyDate;
            }
            WdtGoodsPushInfo wdtGoodsPushInfo = new WdtGoodsPushInfo();
            // 默认单位：件
            wdtGoodsPushInfo.setUnit_name("件");
            wdtGoodsPushInfo.setShort_name(productDs.getProsname());
            wdtGoodsPushInfo.setOrigin(productDs.getArea());
            // 默认销售货品
            wdtGoodsPushInfo.setGoods_type(1);
            wdtGoodsPushInfo.setGoods_no(productDs.getProid());
            wdtGoodsPushInfo.setGoods_name(productDs.getProsname());
            // 默认分类名称
            wdtGoodsPushInfo.setClass_name("");
            // 默认品牌名：谢菲德
            wdtGoodsPushInfo.setBrand_name("谢菲德");
            List<WdtGoodsSpecPushInfo> spec_list = new ArrayList<>();
//            wdtGoodsSpecPushInfo.setIs_allow_neg_stock(productDs.getIsAllowNegStock());
//            wdtGoodsSpecPushInfo.setLowest_price(productDs.getLowestPrice());
//            wdtGoodsSpecPushInfo.setMarket_price(productDs.getMarketPrice());
//            wdtGoodsSpecPushInfo.setTax_rate();
            WdtGoodsSpecPushInfo wdtGoodsSpecPushInfo = new WdtGoodsSpecPushInfo();
            wdtGoodsSpecPushInfo.setBarcode(productDs.getProid());
            wdtGoodsSpecPushInfo.setHeight(productDs.getHeight());
            wdtGoodsSpecPushInfo.setLength(productDs.getLength());
            wdtGoodsSpecPushInfo.setMember_price(productDs.getMemberprice());
            wdtGoodsSpecPushInfo.setRetail_price(productDs.getNormalprice());
            wdtGoodsSpecPushInfo.setSpec_code(productDs.getSpec());
            wdtGoodsSpecPushInfo.setSpec_name(productDs.getProname());
            wdtGoodsSpecPushInfo.setSpec_no(productDs.getProid());
            // 默认单位：件
            wdtGoodsSpecPushInfo.setSpec_unit_name("件");
            wdtGoodsSpecPushInfo.setWeight(productDs.getWeight());
            wdtGoodsSpecPushInfo.setWholesale_price(productDs.getGroupprice());
            wdtGoodsSpecPushInfo.setWidth(productDs.getWidth());
            spec_list.add(wdtGoodsSpecPushInfo);
            wdtGoodsPushInfo.setSpec_list(spec_list);
            wdtGoodsPushInfoList.add(wdtGoodsPushInfo);
        }
        syncResult.setMaxModifyDate(maxModifyDate);
    }

    public AbstractResultBase goodsBatchPushToWdt(List<WdtGoodsPushInfo> wdtGoodsPushInfoList){
        AbstractResultBase abstractResultBase = new AbstractResultBase();
        try {
            // 批量推送，goods_list不大于100条，goods_list下的spec_list条数不能超过2000条
            List<List<WdtGoodsPushInfo>> averageList = ListUtils.part(wdtGoodsPushInfoList, 100);
            for (final List<WdtGoodsPushInfo> eachList : averageList) {
                if (eachList == null || eachList.size() == 0) {
                    continue;
                }
                WdtBaseResult wdtBaseResult = wdtApiIntegration.goodsPush(eachList);
                if(!wdtBaseResult.isSuccess()) {
                    abstractResultBase.setDetailMessage(abstractResultBase.getDetailMessage() + wdtBaseResult.getMessage());
                    abstractResultBase.setSuccess(false);
                    log.error("推送旺店通失败，失败原因："+abstractResultBase.getDetailMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            abstractResultBase.setSuccess(false);
        }
        return abstractResultBase;
    }
}
