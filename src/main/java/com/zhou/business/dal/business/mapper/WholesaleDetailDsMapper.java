package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.WholesaleDetailDs;
import com.zhou.business.dal.business.entity.WholesaleDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WholesaleDetailDsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(WholesaleDetailKey key);

    /**
     *
     * @mbggenerated
     */
    int insert(WholesaleDetailDs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WholesaleDetailDs record);

    /**
     *
     * @mbggenerated
     */
    WholesaleDetailDs selectByPrimaryKey(WholesaleDetailKey key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WholesaleDetailDs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WholesaleDetailDs record);

    /**
     *
     * @param wholesaleDetailDsList
     */
    void batchSave(List<WholesaleDetailDs> wholesaleDetailDsList);

    /**
     *
     * @param wholesaleid
     * @param proid
     * @return
     */
    WholesaleDetailDs selectByWholesaleidAndProid(@Param("wholesaleid") String wholesaleid, @Param("proid") String proid);
}