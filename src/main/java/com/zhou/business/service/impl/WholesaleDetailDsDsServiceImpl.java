package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.WholesaleDetailDs;
import com.zhou.business.dal.business.mapper.WholesaleDetailDsMapper;
import com.zhou.business.service.WholesaleDetailDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 19:10
 */
@Service
public class WholesaleDetailDsDsServiceImpl implements WholesaleDetailDsService {

    @Autowired
    private WholesaleDetailDsMapper wholesaleDetailDsMapper;

    @Override
    public void batchSave(List<WholesaleDetailDs> wholesaleDetailDsList) {
        wholesaleDetailDsMapper.batchSave(wholesaleDetailDsList);
    }

    @Override
    public WholesaleDetailDs getByWholesaleidAndProid(String wholesaleid, String proid) {
        return wholesaleDetailDsMapper.selectByWholesaleidAndProid(wholesaleid,proid);
    }
}
