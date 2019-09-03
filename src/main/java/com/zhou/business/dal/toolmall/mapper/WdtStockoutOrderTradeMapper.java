package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.WdtStockoutOrderTrade;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WdtStockoutOrderTradeMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(WdtStockoutOrderTrade record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WdtStockoutOrderTrade record);

    /**
     *
     * @mbggenerated
     */
    WdtStockoutOrderTrade selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WdtStockoutOrderTrade record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WdtStockoutOrderTrade record);


    List<WdtStockoutOrderTrade> selectByShopNoAndGmtCreate(@Param("shopNo")String shopNo, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}