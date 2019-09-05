package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.WholesaleDetail;
import com.zhou.business.dal.business.mapper.WholesaleDetailMapper;
import com.zhou.business.service.WholesaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 19:10
 */
@Service
public class WholesaleDetailServiceImpl implements WholesaleDetailService {

    @Autowired
    private WholesaleDetailMapper wholesaleDetailMapper;

    @Override
    public void batchSave(List<WholesaleDetail> wholesaleDetailList) {
        wholesaleDetailMapper.batchSave(wholesaleDetailList);
    }

    @Override
    public WholesaleDetail getByWholesaleidAndProid(String wholesaleid, String proid) {
        return wholesaleDetailMapper.selectByWholesaleidAndProid(wholesaleid,proid);
    }
}
