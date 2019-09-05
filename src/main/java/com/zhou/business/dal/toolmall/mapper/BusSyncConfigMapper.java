package com.zhou.business.dal.toolmall.mapper;

import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface BusSyncConfigMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int insert(BusSyncConfig record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(BusSyncConfig record);

    /**
     *
     * @mbggenerated
     */
    BusSyncConfig selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BusSyncConfig record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BusSyncConfig record);

    /**
     *
     * @param code
     * @return
     */
    BusSyncConfig selectByCode(String code);

    /**
     *
     * @param gmtNextSync
     * @param code
     * @return
     */
    int updateGmtNextSyncByCode(@Param("gmtNextSync") Date gmtNextSync, @Param("code")String code);
}