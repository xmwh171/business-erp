package com.zhou.business.wdtclient.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:36
 */
public class WdtStockinOrderItem {

    /**
     * 商家编码
     */
    private String spec_no;
    /**
     * 入库数量
     */
    private BigDecimal stockin_num;
    /**
     * 货位编号
     */
    private String position_no;
    /**
     * 批次
     */
    private String batch_no;
    /**
     * 生成日期
     */
    private Date production_date;
    /**
     * 有效期天数
     */
    private int validity_days;
    /**
     * 原价
     */
    private BigDecimal src_price;
    /**
     * 入库价
     */
    private BigDecimal stockin_price;
    /**
     * 税率
     */
    private BigDecimal tax;

    public String getSpec_no() {
        return spec_no;
    }

    public void setSpec_no(String spec_no) {
        this.spec_no = spec_no;
    }

    public BigDecimal getStockin_num() {
        return stockin_num;
    }

    public void setStockin_num(BigDecimal stockin_num) {
        this.stockin_num = stockin_num;
    }

    public String getPosition_no() {
        return position_no;
    }

    public void setPosition_no(String position_no) {
        this.position_no = position_no;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public int getValidity_days() {
        return validity_days;
    }

    public void setValidity_days(int validity_days) {
        this.validity_days = validity_days;
    }

    public BigDecimal getSrc_price() {
        return src_price;
    }

    public void setSrc_price(BigDecimal src_price) {
        this.src_price = src_price;
    }

    public BigDecimal getStockin_price() {
        return stockin_price;
    }

    public void setStockin_price(BigDecimal stockin_price) {
        this.stockin_price = stockin_price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
