package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.WdtStockinOrderRefund;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.request.WdtStockinOrderRefundSyncRequest;

import java.util.List;

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

    /**
     *
     * @param syncRequest
     * @return
     */
    List<WdtStockinOrderRefundSyncModel> selectBySyncRequest(WdtStockinOrderRefundSyncRequest syncRequest);
}