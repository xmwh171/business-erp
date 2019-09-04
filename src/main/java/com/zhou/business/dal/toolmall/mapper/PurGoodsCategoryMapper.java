package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoodsCategory;

public interface PurGoodsCategoryMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PurGoodsCategory record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PurGoodsCategory record);

    /**
     *
     * @mbggenerated
     */
    PurGoodsCategory selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PurGoodsCategory record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PurGoodsCategory record);


    /**
     *
     * @param code
     * @return
     */
    PurGoodsCategory selectByCode(String code);
}