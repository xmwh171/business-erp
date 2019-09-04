package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.dal.business.mapper.ProductDsMapper;
import com.zhou.business.service.ProductDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 17:48
 */
@Service
public class ProductDsServiceImpl implements ProductDsService {

    @Autowired
    private ProductDsMapper productDsMapper;

    @Override
    public List<ProductDs> getByUpdateDate(Date startTime, Date endTime) {
        return productDsMapper.selectByUpdateDate(startTime,endTime);
    }

    @Override
    public ProductDs getByProId(String proid) {
        return productDsMapper.selectByProId(proid);
    }
}
