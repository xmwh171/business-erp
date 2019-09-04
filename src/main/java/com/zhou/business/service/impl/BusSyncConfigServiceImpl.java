package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import com.zhou.business.dal.toolmall.mapper.BusSyncConfigMapper;
import com.zhou.business.service.BusSyncConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 13:27
 */
@Service
public class BusSyncConfigServiceImpl implements BusSyncConfigService {

    @Autowired
    private BusSyncConfigMapper busSyncConfigMapper;

    @Override
    public BusSyncConfig getByCode(String code) {
        return busSyncConfigMapper.selectByCode(code);
    }

    @Override
    public int modifyGmtNextSyncByCode(Date gmtNextSync, String code) {
        return busSyncConfigMapper.updateGmtNextSyncByCode(gmtNextSync,code);
    }
}
