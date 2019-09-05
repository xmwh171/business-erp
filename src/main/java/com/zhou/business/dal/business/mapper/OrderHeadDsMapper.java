package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.dal.business.model.BusinessOrderSyncModel;
import com.zhou.business.request.BusinessOrderSyncRequest;

import java.util.List;

public interface OrderHeadDsMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(OrderHeadDs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(OrderHeadDs record);

    /**
     *
     * @param orderId
     * @return
     */
    OrderHeadDs selectByOrderId(String orderId);

    /**
     *
     * @param syncRequest
     * @return
     */
    List<BusinessOrderSyncModel> selectBySyncRequest(BusinessOrderSyncRequest syncRequest);
}