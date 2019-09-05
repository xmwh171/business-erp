package com.zhou.business.dal.business.model;

import com.zhou.business.dal.business.entity.OrderDetailDs;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/5 14:06
 */
public class BusinessOrderSyncModel {

    /**
     * null OrderId
     */
    private String orderid;

    /**
     * null InputDate
     */
    private Date inputdate;

    /**
     * null BraId
     */
    private String braid;

    /**
     * null SupId
     */
    private String supid;

    /**
     * null OrderType
     */
    private String ordertype;

    /**
     * null OrderMode
     */
    private String ordermode;

    /**
     * null DMId
     */
    private String dmid;

    /**
     * null PreReceiptDate
     */
    private Date prereceiptdate;

    /**
     * null EndDate
     */
    private Date enddate;

    /**
     * null Status
     */
    private String status;

    /**
     * null Status1
     */
    private String status1;

    /**
     * null ReceiptDate
     */
    private Date receiptdate;

    /**
     * null ReceiptId
     */
    private String receiptid;

    /**
     * null ManagerId
     */
    private String managerid;

    /**
     * null OperatorId
     */
    private String operatorid;

    /**
     * null Remark
     */
    private String remark;

    /**
     * null updatedate
     */
    private Date updatedate;

    /**
     * null payableflag
     */
    private String payableflag;

    /**
     * null currencytype
     */
    private String currencytype;

    /**
     * 明细
     */
    private List<OrderDetailDs> itemList;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getInputdate() {
        return inputdate;
    }

    public void setInputdate(Date inputdate) {
        this.inputdate = inputdate;
    }

    public String getBraid() {
        return braid;
    }

    public void setBraid(String braid) {
        this.braid = braid;
    }

    public String getSupid() {
        return supid;
    }

    public void setSupid(String supid) {
        this.supid = supid;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getOrdermode() {
        return ordermode;
    }

    public void setOrdermode(String ordermode) {
        this.ordermode = ordermode;
    }

    public String getDmid() {
        return dmid;
    }

    public void setDmid(String dmid) {
        this.dmid = dmid;
    }

    public Date getPrereceiptdate() {
        return prereceiptdate;
    }

    public void setPrereceiptdate(Date prereceiptdate) {
        this.prereceiptdate = prereceiptdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public Date getReceiptdate() {
        return receiptdate;
    }

    public void setReceiptdate(Date receiptdate) {
        this.receiptdate = receiptdate;
    }

    public String getReceiptid() {
        return receiptid;
    }

    public void setReceiptid(String receiptid) {
        this.receiptid = receiptid;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getPayableflag() {
        return payableflag;
    }

    public void setPayableflag(String payableflag) {
        this.payableflag = payableflag;
    }

    public String getCurrencytype() {
        return currencytype;
    }

    public void setCurrencytype(String currencytype) {
        this.currencytype = currencytype;
    }

    public List<OrderDetailDs> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderDetailDs> itemList) {
        this.itemList = itemList;
    }
}
