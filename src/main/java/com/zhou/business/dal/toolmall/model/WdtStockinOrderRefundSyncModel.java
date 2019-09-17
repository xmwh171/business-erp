package com.zhou.business.dal.toolmall.model;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/5 9:52
 */
public class WdtStockinOrderRefundSyncModel {

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
    private Date gmtModify;

    /**
     *
     */
    private Date checkTime;

    /**
     *
     */
    private String customerName;

    /**
     *
     */
    private List<WdtStockinOrderRefundDetailSyncModel> itemList;

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

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public List<WdtStockinOrderRefundDetailSyncModel> getItemList() {
        return itemList;
    }

    public void setItemList(List<WdtStockinOrderRefundDetailSyncModel> itemList) {
        this.itemList = itemList;
    }
}
