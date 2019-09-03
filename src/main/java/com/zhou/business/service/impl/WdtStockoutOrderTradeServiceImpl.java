package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.WdtStockoutOrderTrade;
import com.zhou.business.dal.toolmall.mapper.WdtStockoutOrderTradeMapper;
import com.zhou.business.service.WdtStockoutOrderTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 15:17
 */
@Service
public class WdtStockoutOrderTradeServiceImpl implements WdtStockoutOrderTradeService {

    @Autowired
    private WdtStockoutOrderTradeMapper wdtStockoutOrderTradeMapper;

    @Override
    public List<WdtStockoutOrderTrade> getByShopNoAndGmtCreate(String shopNo, Date startTime, Date endTime) {
        return wdtStockoutOrderTradeMapper.selectByShopNoAndGmtCreate(shopNo,startTime,endTime);
    }
}
