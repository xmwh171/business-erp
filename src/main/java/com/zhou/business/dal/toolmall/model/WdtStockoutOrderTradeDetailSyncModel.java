package com.zhou.business.dal.toolmall.model;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:04
 */
public class WdtStockoutOrderTradeDetailSyncModel {

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
    private BigDecimal sellPrice;

    /**
     *
     */
    private BigDecimal taxRate;

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

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
