package com.zhou.business.result;

import com.zhou.business.common.api.AbstractResultBase;

import java.util.Date;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 13:36
 */
public class SyncResult extends AbstractResultBase {

    /**
     * 最大更新时间
     */
    private Date maxModifyDate;

    public Date getMaxModifyDate() {
        return maxModifyDate;
    }

    public void setMaxModifyDate(Date maxModifyDate) {
        this.maxModifyDate = maxModifyDate;
    }
}
