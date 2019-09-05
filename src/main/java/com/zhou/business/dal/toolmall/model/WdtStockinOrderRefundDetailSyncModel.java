package com.zhou.business.dal.toolmall.model;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/5 9:53
 */
public class WdtStockinOrderRefundDetailSyncModel {

    /**
     *
     */
    private String specNo;

    /**
     *
     */
    private BigDecimal goodsCount;

    /**
     *
     */
    private BigDecimal srcPrice;

    /**
     *
     */
    private BigDecimal tax;

    /**
     *
     */
    private BigDecimal costPrice;

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public BigDecimal getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(BigDecimal goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getSrcPrice() {
        return srcPrice;
    }

    public void setSrcPrice(BigDecimal srcPrice) {
        this.srcPrice = srcPrice;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
