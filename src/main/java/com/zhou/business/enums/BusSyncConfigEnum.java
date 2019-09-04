package com.zhou.business.enums;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 13:12
 */
public enum BusSyncConfigEnum {

    BUSINESS_GOODS_SYNC("business_goods_sync","商务系统商品同步"),

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
