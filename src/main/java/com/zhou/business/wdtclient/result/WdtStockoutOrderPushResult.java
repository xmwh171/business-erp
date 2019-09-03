package com.zhou.business.wdtclient.result;

import com.zhou.business.common.api.AbstractResultBase;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:40
 */
public class WdtStockoutOrderPushResult extends AbstractResultBase {

    /**
     * 状态码: 0表示成功 其他表示有错
     */
    private int code;

    /**
     * 错误原因
     */
    private String message;

    /**
     * 出库单号
     */
    private String stockout_no;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStockout_no() {
        return stockout_no;
    }

    public void setStockout_no(String stockout_no) {
        this.stockout_no = stockout_no;
    }
}
