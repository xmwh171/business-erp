package com.zhou.business.controller;

import com.zhou.business.common.api.CommonResult;
import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.service.OrderHeadDsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 18:11
 */
@Controller
@Api(tags = "OrderHeadDsController", description = "测试")
@RequestMapping("/orderHeadDs")
public class OrderHeadDsController {

    @Autowired
    private OrderHeadDsService orderHeadDsService;

    @ApiOperation("测试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OrderHeadDs> list(String orderId) {
        OrderHeadDs orderHeadDs = orderHeadDsService.getByOrderId(orderId);
        return CommonResult.success(orderHeadDs);
    }
}
