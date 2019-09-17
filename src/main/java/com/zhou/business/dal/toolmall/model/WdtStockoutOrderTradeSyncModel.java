package com.zhou.business.dal.toolmall.model;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 17:52
 */
public class WdtStockoutOrderTradeSyncModel {

    /**
     *
     */
    private String orderNo;

    /**
     *
     */
    private String customerNo;

    /**
     *
     */
    private Date modified;

    /**
     *
     */
    private Date payTime;

    /**
     *
     */
    private Date stockCheckTime;

    /**
     *
     */
    private String customerName;

    /**
     *
     */
    private List<WdtStockoutOrderTradeDetailSyncModel> itemList;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getStockCheckTime() {
        return stockCheckTime;
    }

    public void setStockCheckTime(Date stockCheckTime) {
        this.stockCheckTime = stockCheckTime;
    }

    public List<WdtStockoutOrderTradeDetailSyncModel> getItemList() {
        return itemList;
    }

    public void setItemList(List<WdtStockoutOrderTradeDetailSyncModel> itemList) {
        this.itemList = itemList;
    }
}
