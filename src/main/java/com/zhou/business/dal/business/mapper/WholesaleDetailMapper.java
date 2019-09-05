package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.WholesaleDetail;
import com.zhou.business.dal.business.entity.WholesaleDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WholesaleDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(WholesaleDetailKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(WholesaleDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WholesaleDetail record);

    /**
     *
     * @mbggenerated
     */
    WholesaleDetail selectByPrimaryKey(WholesaleDetailKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WholesaleDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WholesaleDetail record);

    /**
     *
     * @param wholesaleDetailList
     */
    void batchSave(List<WholesaleDetail> wholesaleDetailList);

    /**
     *
     * @param wholesaleid
     * @param proid
     * @return
     */
    WholesaleDetail selectByWholesaleidAndProid(@Param("wholesaleid") String wholesaleid, @Param("proid") String proid);
}