package com.zhou.business.service;

import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.dal.business.model.BusinessOrderSyncModel;
import com.zhou.business.request.BusinessOrderSyncRequest;
import com.zhou.business.result.SyncResult;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 18:10
 */
public interface OrderHeadDsService {

    /**
     *
     * @param orderId
     * @return
     */
    OrderHeadDs getByOrderId(String orderId);

    /**
     *
     * @param syncRequest
     * @return
     */
    List<BusinessOrderSyncModel> getBySyncRequest(BusinessOrderSyncRequest syncRequest);

    /**
     *
     * @param syncModelList
     * @return
     */
    SyncResult pushToWdtStockin(List<BusinessOrderSyncModel> syncModelList);


    /**
     *
     * @param syncModelList
     * @return
     */
    SyncResult pushToWdtStockout(List<BusinessOrderSyncModel> syncModelList);

}
