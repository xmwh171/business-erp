package com.zhou.business.controller;

import com.zhou.business.common.api.CommonResult;
import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.service.OrderHeadDsService;
import com.zhou.business.service.ProductDsService;
import com.zhou.business.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 17:53
 */
@Controller
@Api(tags = "ProductDsController", description = "测试")
@RequestMapping("/productDs")
public class ProductDsController {

    @Autowired
    private ProductDsService productDsService;

    @ApiOperation("测试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ProductDs>> list(String startTime, String endTime) {
        List<ProductDs> orderHeadDsList = productDsService.getByUpdateDate(DateUtils.parseDateNewFormat(startTime),DateUtils.parseDateNewFormat(endTime));
        return CommonResult.success(orderHeadDsList);
    }

    @ApiOperation("查询")
    @RequestMapping(value = "/queryByProId", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ProductDs> queryByProId(String proId) {
        ProductDs orderHeadDs = productDsService.getByProId(proId);
        return CommonResult.success(orderHeadDs);
    }
}
