package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.WdtStockinOrderRefund;

public interface WdtStockinOrderRefundMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(WdtStockinOrderRefund record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WdtStockinOrderRefund record);

    /**
     *
     * @mbggenerated
     */
    WdtStockinOrderRefund selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WdtStockinOrderRefund record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WdtStockinOrderRefund record);
}