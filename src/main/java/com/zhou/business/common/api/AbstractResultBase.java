package com.zhou.business.common.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 抽象结果基类
 * @Author xiaohu
 * @Date 2018/10/24 9:58
 */
public class AbstractResultBase {

    /**
     * 是否成功
     */
    protected boolean success = true;

    /**
     * 详细信息
     */
    protected String detailMessage;

    /**
     * 返回结果集
     */
    protected Map<String, String> resultMap = new HashMap<String, String>();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }
}
