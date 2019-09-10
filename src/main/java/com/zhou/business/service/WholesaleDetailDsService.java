package com.zhou.business.service;

import com.zhou.business.dal.business.entity.WholesaleDetailDs;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:48
 */
public interface WholesaleDetailDsService {

    /**
     *
     * @param wholesaleDetailDsList
     */
    void batchSave(List<WholesaleDetailDs> wholesaleDetailDsList);

    /**
     *
     * @param wholesaleid
     * @param proid
     * @return
     */
    WholesaleDetailDs getByWholesaleidAndProid(String wholesaleid, String proid);
}
