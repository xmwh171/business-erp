package com.zhou.business.service;

import com.zhou.business.dal.toolmall.entity.WdtStockinOrderRefund;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.request.WdtStockinOrderRefundSyncRequest;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/5 10:13
 */
public interface WdtStockinOrderRefundService {

    /**
     *
     * @param syncRequest
     * @return
     */
    List<WdtStockinOrderRefundSyncModel> getBySyncRequest(WdtStockinOrderRefundSyncRequest syncRequest);
}
