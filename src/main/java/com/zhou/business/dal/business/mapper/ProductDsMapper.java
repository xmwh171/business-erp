package com.zhou.business.dal.business.mapper;

import com.zhou.business.dal.business.entity.ProductDs;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductDsMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(ProductDs record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(ProductDs record);

    /**
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<ProductDs> selectByUpdateDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     *
     * @param proid
     * @return
     */
    ProductDs selectByProId(String proid);
}