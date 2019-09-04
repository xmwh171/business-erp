package com.zhou.business.service;

import com.zhou.business.dal.toolmall.entity.BusSyncConfig;

import java.util.Date;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 13:21
 */
public interface BusSyncConfigService {

    /**
     * 根据code查询
     * @param code
     * @return
     */
    BusSyncConfig getByCode(String code);

    /**
     * 根据code更新下次同步时间
     * @param gmtNextSync
     * @param code
     * @return
     */
    int modifyGmtNextSyncByCode(Date gmtNextSync, String code);
}
