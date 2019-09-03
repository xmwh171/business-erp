package com.zhou.business.service;

import com.zhou.business.dal.business.entity.OrderHeadDs;

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
}
