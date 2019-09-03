package com.zhou.business.wdtclient.model;

import java.util.List;

/**
 * @Description 货品推送信息
 * @Author xiaohu
 * @Date 2018/10/25 15:31
 */
public class WdtGoodsPushInfo {

    /**
     * 货品编号
     */
    private String goods_no;

    /**
     * 货品类别 1销售商品 2原材料 3包装 4周转材料5虚拟商品6固定资产 0其它
     */
    private Integer goods_type;

    /**
     * 货品名称
     */
    private String goods_name;

    /**
     * 货品简称
     */
    private String short_name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 拼音名称
     */
    private String pinyin;

    /**
     * 产地
     */
    private String origin;

    /**
     * 类别名称
     */
    private String class_name;

    /**
     * 品牌名称
     */
    private String brand_name;

    /**
     * 基本单位
     */
    private String unit_name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 自定义属性1
     */
    private String props1;

    /**
     * 自定义属性2
     */
    private String props2;

    /**
     * 自定义属性3
     */
    private String props3;

    /**
     * 自定义属性4
     */
    private String props4;

    /**
     * 自定义属性5
     */
    private String props5;

    /**
     * 自定义属性6
     */
    private String props6;

    /**
     * 商品详情列表
     */
    private List<WdtGoodsSpecPushInfo> spec_list;

    public String getGoods_no() {
        return goods_no;
    }

    public void setGoods_no(String goods_no) {
        this.goods_no = goods_no;
    }

    public Integer getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(Integer goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProps1() {
        return props1;
    }

    public void setProps1(String props1) {
        this.props1 = props1;
    }

    public String getProps2() {
        return props2;
    }

    public void setProps2(String props2) {
        this.props2 = props2;
    }

    public String getProps3() {
        return props3;
    }

    public void setProps3(String props3) {
        this.props3 = props3;
    }

    public String getProps4() {
        return props4;
    }

    public void setProps4(String props4) {
        this.props4 = props4;
    }

    public String getProps5() {
        return props5;
    }

    public void setProps5(String props5) {
        this.props5 = props5;
    }

    public String getProps6() {
        return props6;
    }

    public void setProps6(String props6) {
        this.props6 = props6;
    }

    public List<WdtGoodsSpecPushInfo> getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(List<WdtGoodsSpecPushInfo> spec_list) {
        this.spec_list = spec_list;
    }
}
