package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.WholesaleHead;

import java.util.List;

public interface WholesaleHeadMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String wholesaleid);

    /**
     *
     * @mbggenerated
     */
    int insert(WholesaleHead record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WholesaleHead record);

    /**
     *
     * @mbggenerated
     */
    WholesaleHead selectByPrimaryKey(String wholesaleid);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WholesaleHead record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WholesaleHead record);

    /**
     *
     * @param wholesaleHeadList
     */
    void batchSave(List<WholesaleHead> wholesaleHeadList);

    /**
     *
     * @param wholesaleids
     * @return
     */
    List<String> selectWholesaleidsByWholesaleids(List<String> wholesaleids);
}