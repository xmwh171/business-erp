package com.zhou.business.service.impl;

import com.zhou.business.dal.toolmall.entity.WdtStockinOrderRefund;
import com.zhou.business.dal.toolmall.mapper.WdtStockinOrderRefundMapper;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.request.WdtStockinOrderRefundSyncRequest;
import com.zhou.business.service.WdtStockinOrderRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/5 10:14
 */
@Service
public class WdtStockinOrderRefundServiceImpl implements WdtStockinOrderRefundService {

    @Autowired
    private WdtStockinOrderRefundMapper wdtStockinOrderRefundMapper;

    @Override
    public List<WdtStockinOrderRefundSyncModel> getBySyncRequest(WdtStockinOrderRefundSyncRequest syncRequest) {
        return wdtStockinOrderRefundMapper.selectBySyncRequest(syncRequest);
    }
}
