package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.dal.business.mapper.OrderHeadDsMapper;
import com.zhou.business.service.OrderHeadDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 18:10
 */
@Service
public class OrderHeadDsServiceImpl implements OrderHeadDsService {

    @Autowired
    private OrderHeadDsMapper orderHeadDsMapper;

    @Override
    public OrderHeadDs getByOrderId(String orderId) {
        return orderHeadDsMapper.selectByOrderId(orderId);
    }
}
