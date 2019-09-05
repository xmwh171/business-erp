package com.zhou.business.request;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:13
 */
public class WdtStockoutOrderTradeSyncRequest {

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 仓库编号集合
     */
    private List<String> warehouseNoList;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<String> getWarehouseNoList() {
        return warehouseNoList;
    }

    public void setWarehouseNoList(List<String> warehouseNoList) {
        this.warehouseNoList = warehouseNoList;
    }
}
