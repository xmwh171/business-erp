package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.PurGoodsCategory;
import com.zhou.business.dal.toolmall.mapper.PurGoodsCategoryMapper;
import com.zhou.business.service.PurGoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 9:08
 */
@Service
public class PurGoodsCategoryServiceImpl implements PurGoodsCategoryService {

    @Autowired
    private PurGoodsCategoryMapper purGoodsCategoryMapper;

    @Override
    public PurGoodsCategory getByCode(String code) {
        return purGoodsCategoryMapper.selectByCode(code);
    }
}
