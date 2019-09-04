package com.zhou.business.service;

import com.zhou.business.dal.toolmall.entity.PurGoodsCategory;

/**
 * @Description
 * @Author xiaohu
 * @Date 2018/11/1 14:46
 */
public interface PurGoodsCategoryService {

    /**
     * 根据编码查询
     * @param code
     * @return
     */
    PurGoodsCategory getByCode(String code);

}
