package com.zhou.business.wdtclient.result;


import com.zhou.business.common.api.AbstractResultBase;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 15:20
 */
public class WdtBaseResult extends AbstractResultBase {

    /**
     * 错误码，0成功
     */
    private int code;

    /**
     * 错误描述
     */
    private String message;

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
}
