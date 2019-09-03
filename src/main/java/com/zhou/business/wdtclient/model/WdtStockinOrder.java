package com.zhou.business.wdtclient.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:36
 */
public class WdtStockinOrder {

    /**
     * 外部单据号
     */
    private String outer_no;
    /**
     * 仓库编号
     */
    private String warehouse_no;
    /**
     * 物流编号
     */
    private String logistics_code;
    /**
     * 物流单号
     */
    private String logistics_no;

    /**
     * 是否审核
     */
    private int is_check;

    /**
     * 是否创建批次
     */
    private String is_create_batch;

    /**
     * 邮费
     */
    private BigDecimal post_fee;

    /**
     * 其他费用
     */
    private BigDecimal other_fee;

    /**
     * 备注
     */
    private String remark;

    /**
     * 货品明细节点
     */
    private List<WdtStockinOrderItem> goods_list;

    public String getOuter_no() {
        return outer_no;
    }

    public void setOuter_no(String outer_no) {
        this.outer_no = outer_no;
    }

    public String getWarehouse_no() {
        return warehouse_no;
    }

    public void setWarehouse_no(String warehouse_no) {
        this.warehouse_no = warehouse_no;
    }

    public String getLogistics_code() {
        return logistics_code;
    }

    public void setLogistics_code(String logistics_code) {
        this.logistics_code = logistics_code;
    }

    public String getLogistics_no() {
        return logistics_no;
    }

    public void setLogistics_no(String logistics_no) {
        this.logistics_no = logistics_no;
    }

    public int getIs_check() {
        return is_check;
    }

    public void setIs_check(int is_check) {
        this.is_check = is_check;
    }

    public String getIs_create_batch() {
        return is_create_batch;
    }

    public void setIs_create_batch(String is_create_batch) {
        this.is_create_batch = is_create_batch;
    }

    public BigDecimal getPost_fee() {
        return post_fee;
    }

    public void setPost_fee(BigDecimal post_fee) {
        this.post_fee = post_fee;
    }

    public BigDecimal getOther_fee() {
        return other_fee;
    }

    public void setOther_fee(BigDecimal other_fee) {
        this.other_fee = other_fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<WdtStockinOrderItem> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<WdtStockinOrderItem> goods_list) {
        this.goods_list = goods_list;
    }
}
