package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.WholesaleDetail;
import com.zhou.business.dal.business.entity.WholesaleDetailKey;

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
}