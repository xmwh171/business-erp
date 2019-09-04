package com.zhou.business.service;

import com.zhou.business.dal.toolmall.entity.PurGoodsSpec;
import com.zhou.business.result.PurGoodsSpecOperateResult;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 9:11
 */
public interface PurGoodsSpecService {

    /**
     *
     * @param purGoodsSpec
     * @return
     */
    PurGoodsSpecOperateResult create(PurGoodsSpec purGoodsSpec);

    /**
     *
     * @param purGoodsSpecList
     * @return
     */
    PurGoodsSpecOperateResult batchCreate(List<PurGoodsSpec> purGoodsSpecList);

    /**
     *
     * @param barcode
     * @return
     */
    PurGoodsSpec getByBarcode(String barcode);

    /**
     *
     * @param purGoodsSpecList
     */
    void batchSave(List<PurGoodsSpec> purGoodsSpecList);
}
