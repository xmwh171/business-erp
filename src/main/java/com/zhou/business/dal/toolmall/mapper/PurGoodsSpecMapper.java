package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoodsSpec;

public interface PurGoodsSpecMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(PurGoodsSpec record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PurGoodsSpec record);

    /**
     *
     * @mbggenerated
     */
    PurGoodsSpec selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PurGoodsSpec record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PurGoodsSpec record);
}