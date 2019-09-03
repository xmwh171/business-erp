package com.zhou.business.wdtclient.model;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:49
 */
public class WdtGoodsSpecPushInfo {

    /**
     * 商家编码(ERP内单品唯一编码)
     */
    private String spec_no;

    /**
     * 规格编码
     */
    private String spec_code;

    /**
     * 主条码
     */
    private String barcode;

    /**
     * 规格名称
     */
    private String spec_name;

    /**
     * 是否允许负库存1允许，0不允许（默认为1）
     */
    private Integer is_allow_neg_stock;

    /**
     * 基本单位名称
     */
    private String spec_unit_name;

    /**
     * 最低价
     */
    private BigDecimal lowest_price;

    /**
     * 图片url地址
     */
    private String img_url;

    /**
     * 零售价
     */
    private BigDecimal retail_price;

    /**
     * 批发价
     */
    private BigDecimal wholesale_price;

    /**
     * 会员价
     */
    private BigDecimal member_price;

    /**
     * 市场价
     */
    private BigDecimal market_price;

    /**
     * 销售积分
     */
    private BigDecimal sale_score;

    /**
     * 打包积分
     */
    private BigDecimal pack_score;

    /**
     * 拣货积分
     */
    private BigDecimal pick_score;

    /**
     * 保质期，天数
     */
    private int validity_days;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 长(CM)
     */
    private BigDecimal length;

    /**
     * 宽(CM)
     */
    private BigDecimal width;

    /**
     * 高(CM)
     */
    private BigDecimal height;

    /**
     * 税率
     */
    private BigDecimal tax_rate;

    /**
     * 自定义属性1
     */
    private String prop1;

    /**
     * 自定义属性2
     */
    private String prop2;

    /**
     * 自定义属性3
     */
    private String prop3;

    /**
     * 自定义属性4
     */
    private String prop4;

    /**
     * 自定义属性5
     */
    private String prop5;

    /**
     * 自定义属性6
     */
    private String prop6;

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

    public String getSpec_code() {
        return spec_code;
    }

    public void setSpec_code(String spec_code) {
        this.spec_code = spec_code;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    public Integer getIs_allow_neg_stock() {
        return is_allow_neg_stock;
    }

    public void setIs_allow_neg_stock(Integer is_allow_neg_stock) {
        this.is_allow_neg_stock = is_allow_neg_stock;
    }

    public String getSpec_unit_name() {
        return spec_unit_name;
    }

    public void setSpec_unit_name(String spec_unit_name) {
        this.spec_unit_name = spec_unit_name;
    }

    public BigDecimal getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(BigDecimal lowest_price) {
        this.lowest_price = lowest_price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public BigDecimal getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(BigDecimal retail_price) {
        this.retail_price = retail_price;
    }

    public BigDecimal getWholesale_price() {
        return wholesale_price;
    }

    public void setWholesale_price(BigDecimal wholesale_price) {
        this.wholesale_price = wholesale_price;
    }

    public BigDecimal getMember_price() {
        return member_price;
    }

    public void setMember_price(BigDecimal member_price) {
        this.member_price = member_price;
    }

    public BigDecimal getMarket_price() {
        return market_price;
    }

    public void setMarket_price(BigDecimal market_price) {
        this.market_price = market_price;
    }

    public BigDecimal getSale_score() {
        return sale_score;
    }

    public void setSale_score(BigDecimal sale_score) {
        this.sale_score = sale_score;
    }

    public BigDecimal getPack_score() {
        return pack_score;
    }

    public void setPack_score(BigDecimal pack_score) {
        this.pack_score = pack_score;
    }

    public BigDecimal getPick_score() {
        return pick_score;
    }

    public void setPick_score(BigDecimal pick_score) {
        this.pick_score = pick_score;
    }

    public int getValidity_days() {
        return validity_days;
    }

    public void setValidity_days(int validity_days) {
        this.validity_days = validity_days;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(BigDecimal tax_rate) {
        this.tax_rate = tax_rate;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp4() {
        return prop4;
    }

    public void setProp4(String prop4) {
        this.prop4 = prop4;
    }

    public String getProp5() {
        return prop5;
    }

    public void setProp5(String prop5) {
        this.prop5 = prop5;
    }

    public String getProp6() {
        return prop6;
    }

    public void setProp6(String prop6) {
        this.prop6 = prop6;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
