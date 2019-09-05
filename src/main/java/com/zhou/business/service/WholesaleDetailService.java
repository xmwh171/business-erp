package com.zhou.business.service;

import com.zhou.business.dal.business.entity.WholesaleDetail;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:48
 */
public interface WholesaleDetailService {

    /**
     *
     * @param wholesaleDetailList
     */
    void batchSave(List<WholesaleDetail> wholesaleDetailList);

    /**
     *
     * @param wholesaleid
     * @param proid
     * @return
     */
    WholesaleDetail getByWholesaleidAndProid(String wholesaleid, String proid);
}
