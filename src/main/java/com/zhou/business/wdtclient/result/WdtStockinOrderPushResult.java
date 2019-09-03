package com.zhou.business.wdtclient.result;

import com.zhou.business.common.api.AbstractResultBase;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 16:35
 */
public class WdtStockinOrderPushResult extends AbstractResultBase {

    /**
     * 状态码: 0表示成功 其他表示有错
     */
    private int code;

    /**
     * 错误原因
     */
    private String message;

    /**
     * 入库单号
     */
    private String stockin_no;

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

    public String getStockin_no() {
        return stockin_no;
    }

    public void setStockin_no(String stockin_no) {
        this.stockin_no = stockin_no;
    }
}
