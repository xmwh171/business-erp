package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.PurGoodsBrand;
import com.zhou.business.dal.toolmall.mapper.PurGoodsBrandMapper;
import com.zhou.business.service.PurGoodsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 9:07
 */
@Service
public class PurGoodsBrandServiceImpl implements PurGoodsBrandService {

    @Autowired
    private PurGoodsBrandMapper purGoodsBrandMapper;

    @Override
    public PurGoodsBrand getByBrandName(String brandName) {
        return purGoodsBrandMapper.selectByBrandName(brandName);
    }
}
