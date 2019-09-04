package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoodsBrand;

public interface PurGoodsBrandMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(PurGoodsBrand record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PurGoodsBrand record);

    /**
     *
     * @mbggenerated
     */
    PurGoodsBrand selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PurGoodsBrand record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PurGoodsBrand record);

    /**
     *
     * @param brandName
     * @return
     */
    PurGoodsBrand selectByBrandName(String brandName);
}