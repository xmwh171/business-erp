package com.zhou.business.wdtclient.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:41
 */
public class WdtStockoutOrderInfo {

    /**
     * 外部单号
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
     * 总售价
     */
    private BigDecimal goods_total_amount;

    /**
     * 总成本价
     */
    private BigDecimal goods_total_cost;

    /**
     * 邮费
     */
    private BigDecimal post_cost;

    /**
     * 货品列表节点
     */
    private List<WdtStockoutOrderItem> detail_list;

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

    public BigDecimal getGoods_total_amount() {
        return goods_total_amount;
    }

    public void setGoods_total_amount(BigDecimal goods_total_amount) {
        this.goods_total_amount = goods_total_amount;
    }

    public BigDecimal getGoods_total_cost() {
        return goods_total_cost;
    }

    public void setGoods_total_cost(BigDecimal goods_total_cost) {
        this.goods_total_cost = goods_total_cost;
    }

    public BigDecimal getPost_cost() {
        return post_cost;
    }

    public void setPost_cost(BigDecimal post_cost) {
        this.post_cost = post_cost;
    }

    public List<WdtStockoutOrderItem> getDetail_list() {
        return detail_list;
    }

    public void setDetail_list(List<WdtStockoutOrderItem> detail_list) {
        this.detail_list = detail_list;
    }
}
