package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.WholesaleHeadDs;

import java.util.List;

public interface WholesaleHeadDsMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String wholesaleid);

    /**
     *
     * @mbggenerated
     */
    int insert(WholesaleHeadDs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WholesaleHeadDs record);

    /**
     *
     * @mbggenerated
     */
    WholesaleHeadDs selectByPrimaryKey(String wholesaleid);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WholesaleHeadDs record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WholesaleHeadDs record);

    /**
     *
     * @param wholesaleHeadDsList
     */
    void batchSave(List<WholesaleHeadDs> wholesaleHeadDsList);

    /**
     *
     * @param wholesaleids
     * @return
     */
    List<String> selectWholesaleidsByWholesaleids(List<String> wholesaleids);
}