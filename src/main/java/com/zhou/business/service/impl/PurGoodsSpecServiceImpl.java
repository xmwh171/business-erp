package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.PurGoodsSpec;
import com.zhou.business.dal.toolmall.mapper.PurGoodsSpecMapper;
import com.zhou.business.result.PurGoodsSpecOperateResult;
import com.zhou.business.service.PurGoodsSpecService;
import com.zhou.business.util.ListUtils;
import com.zhou.business.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 9:19
 */
@Service
public class PurGoodsSpecServiceImpl implements PurGoodsSpecService {


    @Value("${sqlServer.parameterCount}")
    private int parameterCount;

    @Autowired
    private PurGoodsSpecMapper purGoodsSpecMapper;

    @Override
    public void batchSave(List<PurGoodsSpec> purGoodsSpecList) {
        if(purGoodsSpecList.size()==0){
            return ;
        }
        List<List<PurGoodsSpec>> averageList = ListUtils.part(purGoodsSpecList, parameterCount/PurGoodsSpec.class.getDeclaredFields().length);
        for (final List<PurGoodsSpec> eachList : averageList) {
            if (eachList == null || eachList.size() == 0) {
                continue;
            }
            purGoodsSpecMapper.batchSave(eachList);
        }
        return ;
    }

    @Override
    public PurGoodsSpecOperateResult create(PurGoodsSpec purGoodsSpec) {
        PurGoodsSpecOperateResult result = new PurGoodsSpecOperateResult();
        if(StringUtils.isEmpty(purGoodsSpec.getSpecNo())){
            result.setSuccess(false);
            result.setDetailMessage("商品编码不能为空");
            return result;
        }
        if(StringUtils.isEmpty(purGoodsSpec.getBarcode())){
            result.setSuccess(false);
            result.setDetailMessage("条码不能为空");
            return result;
        }
        if(StringUtils.isEmpty(purGoodsSpec.getSpecUnitName())){
            result.setSuccess(false);
            result.setDetailMessage("商品："+purGoodsSpec.getSpecNo()+" 的基本单位为空");
            return result;
        }
        PurGoodsSpec existPurGoodsSpec = getByBarcode(purGoodsSpec.getBarcode());
        if(existPurGoodsSpec != null && existPurGoodsSpec.isEnabled()){
            result.setSuccess(false);
            result.setDetailMessage("条码"+purGoodsSpec.getBarcode()+"已存在");
            return result;
        }
        existPurGoodsSpec = purGoodsSpecMapper.selectBySpecNoAndEnabled(purGoodsSpec.getSpecNo(),null);
        if(existPurGoodsSpec != null){
            if(existPurGoodsSpec.isEnabled()){
                purGoodsSpec.setEnabled(true);
                purGoodsSpec.setId(existPurGoodsSpec.getId());
                purGoodsSpecMapper.updateByPrimaryKeySelective(purGoodsSpec);
            }else{
                result.setSuccess(false);
                result.setDetailMessage("该"+purGoodsSpec.getSpecNo()+"商品编码已存在");
                return result;
            }

        }

        result.setSuccess(true);
        return result;
    }

    @Override
    public PurGoodsSpecOperateResult batchCreate(List<PurGoodsSpec> purGoodsSpecList) {
        PurGoodsSpecOperateResult result = new PurGoodsSpecOperateResult();
        for(PurGoodsSpec purGoodsSpec : purGoodsSpecList){
            PurGoodsSpecOperateResult purGoodsSpecOperateResult = create(purGoodsSpec);
            if(!purGoodsSpecOperateResult.isSuccess()){
                result.setSuccess(false);
                result.setDetailMessage(purGoodsSpecOperateResult.getDetailMessage());
                return result;
            }
        }
        result.setSuccess(true);
        return result;
    }

    @Override
    public PurGoodsSpec getByBarcode(String barcode) {
        return purGoodsSpecMapper.selectByBarcode(barcode);
    }


}
