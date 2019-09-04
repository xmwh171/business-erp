package com.zhou.business.service;


import com.zhou.business.dal.toolmall.entity.PurGoodsBrand;

/**
 * @Description
 * @Author xiaohu
 * @Date 2018/11/1 15:48
 */
public interface PurGoodsBrandService {

    /**
     *
     * @param brandName
     * @return
     */
    PurGoodsBrand getByBrandName(String brandName);

}
