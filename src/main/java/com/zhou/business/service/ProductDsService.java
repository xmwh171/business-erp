package com.zhou.business.service;

import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.result.SyncResult;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 17:47
 */
public interface ProductDsService {

    /**
     * 根据更新时间范围查询
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<ProductDs> getByUpdateDate(Date startTime, Date endTime);

    /**
     * 根据prodId查询
     *
     * @param proId
     * @return
     */
    ProductDs getByProId(String proId);

    /**
     * 推送数据至旺店通
     *
     * @param productDsList
     * @return
     */
    SyncResult pushToWdt(List<ProductDs> productDsList);
}
