package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    PurGoods selectByGoodsNoAndEnabled(@Param("goodsNo")String goodsNo, @Param("enabled")Integer enabled);

    void batchSave(List<PurGoods> purGoodsList);

}