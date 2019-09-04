package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.PurGoodsSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    PurGoodsSpec selectByBarcode(String barcode);

    PurGoodsSpec selectBySpecNoAndEnabled(@Param("specNo")String specNo, @Param("enabled")Integer enabled);

    void batchSave(List<PurGoodsSpec> purGoodsSpecList);
}