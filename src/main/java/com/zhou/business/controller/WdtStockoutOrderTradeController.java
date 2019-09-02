package com.zhou.business.controller;

import com.zhou.business.common.api.CommonResult;
import com.zhou.business.dal.entity.WdtStockoutOrderTrade;
import com.zhou.business.service.WdtStockoutOrderTradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 15:19
 */
@Controller
@Api(tags = "WdtStockoutOrderTradeController", description = "测试")
@RequestMapping("/test")
public class WdtStockoutOrderTradeController {

    @Autowired
    private WdtStockoutOrderTradeService wdtStockoutOrderTradeService;

    @ApiOperation("测试")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<WdtStockoutOrderTrade>> list(String shopNo, Date startTime, Date endTime) {
        List<WdtStockoutOrderTrade> wdtStockoutOrderTradeList = wdtStockoutOrderTradeService.getByShopNoAndGmtCreate(shopNo,startTime,endTime);
        return CommonResult.success(wdtStockoutOrderTradeList);
    }
}
