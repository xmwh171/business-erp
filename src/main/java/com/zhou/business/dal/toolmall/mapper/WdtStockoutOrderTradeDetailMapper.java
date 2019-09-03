package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.WdtStockoutOrderTradeDetail;

public interface WdtStockoutOrderTradeDetailMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(WdtStockoutOrderTradeDetail record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WdtStockoutOrderTradeDetail record);

    /**
     *
     * @mbggenerated
     */
    WdtStockoutOrderTradeDetail selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WdtStockoutOrderTradeDetail record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WdtStockoutOrderTradeDetail record);
}