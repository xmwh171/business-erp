package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.OrderHeadDs;

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
}