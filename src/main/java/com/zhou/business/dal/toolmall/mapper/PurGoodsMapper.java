package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoods;

public interface PurGoodsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(PurGoods record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PurGoods record);

    /**
     *
     * @mbggenerated
     */
    PurGoods selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PurGoods record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PurGoods record);
}