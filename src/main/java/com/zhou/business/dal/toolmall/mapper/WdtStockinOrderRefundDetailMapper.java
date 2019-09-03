package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.WdtStockinOrderRefundDetail;

public interface WdtStockinOrderRefundDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(WdtStockinOrderRefundDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WdtStockinOrderRefundDetail record);

    /**
     *
     * @mbggenerated
     */
    WdtStockinOrderRefundDetail selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WdtStockinOrderRefundDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WdtStockinOrderRefundDetail record);
}