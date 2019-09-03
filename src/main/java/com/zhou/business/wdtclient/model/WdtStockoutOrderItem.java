package com.zhou.business.wdtclient.model;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:43
 */
public class WdtStockoutOrderItem {

    /**
     * 商家编码
     */
    private String spec_no;

    /**
     * 出库数量
     */
    private BigDecimal num;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 货位编号
     */
    private String position_no;

    /**
     * 批次号
     */
    private String batch_no;

    /**
     * 备注
     */
    private String remark;

    public String getSpec_no() {
        return spec_no;
    }

    public void setSpec_no(String spec_no) {
        this.spec_no = spec_no;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
