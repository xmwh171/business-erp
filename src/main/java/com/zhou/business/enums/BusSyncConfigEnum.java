package com.zhou.business.enums;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 13:12
 */
public enum BusSyncConfigEnum {

    BUSINESS_PRODUCT_SYNC("business_product_sync","商务系统商品同步"),

    BUSINESS_ORDER_SYNC_TO_WDT_STOCKIN("business_order_sync_to_wdt_stockin","商务系统订单同步至旺店通其他入库"),

    BUSINESS_ORDER_SYNC_TO_WDT_STOCKOUT("business_order_sync_to_wdt_stockout","商务系统订单同步至旺店通其他出库"),

    WDT_STOCKOUT_ORDER_SYNC("wdt_stockout_order_sync","旺店通销售出库单同步至商务销售订单"),

    WDT_STOCKIN_ORDER_REFUND_SYNC("wdt_stockin_order_refund_sync","旺店通销售退货入库单同步至商务销售订单"),

    ;

    private String message;

    private String code;

    private BusSyncConfigEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String message() {
        // TODO Auto-generated method stub
        return message;
    }

    public String code() {
        // TODO Auto-generated method stub
        return code;
    }

    public Number value() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
