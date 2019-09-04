package com.zhou.business.service;

import com.zhou.business.dal.business.entity.ProductDs;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 17:47
 */
public interface ProductDsService {

    /**
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<ProductDs> getByUpdateDate(Date startTime, Date endTime);


    ProductDs getByProId(String proid);
}
