package com.zhou.business.task;

import com.zhou.business.dal.business.model.BusinessOrderSyncModel;
import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import com.zhou.business.enums.BusSyncConfigEnum;
import com.zhou.business.request.BusinessOrderSyncRequest;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.BusSyncConfigService;
import com.zhou.business.service.OrderHeadDsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 15:46
 */
@Slf4j
@Component
public class SalesOrderSyncToWdtStockinTask {

    @Autowired
    private BusSyncConfigService busSyncConfigService;

    @Autowired
    private OrderHeadDsService orderHeadDsService;

    @Scheduled(cron = "0 0 6 * * ?")
    private void execute() {

        BusSyncConfig busSyncConfig = busSyncConfigService.getByCode(BusSyncConfigEnum.BUSINESS_ORDER_SYNC_TO_WDT_STOCKIN.code());
        if(busSyncConfig == null){
            return;
        }
        BusinessOrderSyncRequest syncRequest = new BusinessOrderSyncRequest();
        syncRequest.setStartTime(busSyncConfig.getGmtNextSync());
        syncRequest.setEndTime(new Date());
        syncRequest.setStatus("2");
        List<String> orderTypeList = new ArrayList<>();
        orderTypeList.add("0");
        orderTypeList.add("4");
        syncRequest.setOrderTypeList(orderTypeList);
        List<BusinessOrderSyncModel> syncModelList = orderHeadDsService.getBySyncRequest(syncRequest);
        if(syncModelList.size()>0){
           SyncResult syncResult = orderHeadDsService.pushToWdtStockin(syncModelList);
           if(syncResult.isSuccess()){
               busSyncConfigService.modifyGmtNextSyncByCode(syncResult.getMaxModifyDate(),BusSyncConfigEnum.BUSINESS_ORDER_SYNC_TO_WDT_STOCKIN.code());
           }else {
               log.error("商务系统订单同步至旺店通其他入库错误，原因："+syncResult.getDetailMessage());
           }
        }
    }
}