package com.zhou.business.service;

import com.zhou.business.common.api.AbstractResultBase;
import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.dal.toolmall.entity.PurGoods;
import com.zhou.business.result.PurGoodsOperateResult;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 18:42
 */
public interface PurGoodsService {

    /**
     *
     * @param purGoods
     * @return
     */
    PurGoodsOperateResult create(PurGoods purGoods);

    /**
     *
     * @param purGoodsList
     * @return
     */
    PurGoodsOperateResult batchCreate(List<PurGoods> purGoodsList);

    /**
     *
     * @param productDsList
     * @return
     */
    AbstractResultBase stuffGoods(List<ProductDs> productDsList);

    /**
     * 批量插入
     * @param purGoodsList
     */
    void batchSave(List<PurGoods> purGoodsList);
}
