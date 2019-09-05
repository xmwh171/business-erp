package com.zhou.business.service;

import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeSyncModel;
import com.zhou.business.result.SyncResult;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:34
 */
public interface WholeHeadService {

    /**
     * 销售出库单同步
     *
     * @param syncModelList
     * @return
     */
    SyncResult stockoutOrderTradeSync(List<WdtStockoutOrderTradeSyncModel> syncModelList);

    /**
     * 退货入库单同步
     *
     * @param syncModelList
     * @return
     */
    SyncResult stockinOrderRefundSync(List<WdtStockinOrderRefundSyncModel> syncModelList);

}
