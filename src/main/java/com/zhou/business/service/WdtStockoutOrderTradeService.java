package com.zhou.business.service;

import com.zhou.business.dal.entity.WdtStockoutOrderTrade;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 15:17
 */
public interface WdtStockoutOrderTradeService {

    /**
     * 根据创建时间和店铺编号
     * @param shopNo
     * @param startTime
     * @param endTime
     * @return
     */
    List<WdtStockoutOrderTrade> getByShopNoAndGmtCreate(String shopNo, Date startTime, Date endTime);
}
