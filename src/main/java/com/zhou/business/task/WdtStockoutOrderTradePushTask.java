package com.zhou.business.task;

import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeSyncModel;
import com.zhou.business.enums.BusSyncConfigEnum;
import com.zhou.business.request.WdtStockoutOrderTradeSyncRequest;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.BusSyncConfigService;
import com.zhou.business.service.WdtStockoutOrderTradeService;
import com.zhou.business.service.WholeHeadService;
import com.zhou.business.util.ListUtils;
import com.zhou.business.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Description 旺店通销售出库单同步至商务销售订单定时任务
 * @Author xiaohu
 * @Date 2019/9/4 15:35
 */
@Slf4j
@Component
public class WdtStockoutOrderTradePushTask {

    @Autowired
    private BusSyncConfigService busSyncConfigService;

    @Autowired
    private WdtStockoutOrderTradeService wdtStockoutOrderTradeService;

    @Autowired
    private WholeHeadService wholeHeadService;

    @Scheduled(cron = "0 0/2 * ? * ?")
    private void execute() {

        BusSyncConfig busSyncConfig = busSyncConfigService.getByCode(BusSyncConfigEnum.WDT_STOCKSOUT_ORDER_SYNC.code());
        if(busSyncConfig == null){
            return;
        }
        WdtStockoutOrderTradeSyncRequest syncRequest = new WdtStockoutOrderTradeSyncRequest();
        List<String> warehouseNoList = new ArrayList<>();
        String properties = busSyncConfig.getProperties();
        Map<String, String> propertiesMap = new HashMap<>();
        if(StringUtils.notEmpty(properties)){
            propertiesMap = BusSyncConfig.parseProperties(properties);
        }
        String warehouseNos = propertiesMap.get("warehouse_no");
        if(StringUtils.notEmpty(warehouseNos)){
            warehouseNoList.addAll(ListUtils.toList(StringUtils.split(warehouseNos,"、")));
        }
        syncRequest.setStartTime(busSyncConfig.getGmtNextSync());
        syncRequest.setEndTime(new Date());
        syncRequest.setWarehouseNoList(warehouseNoList);
        List<WdtStockoutOrderTradeSyncModel> syncModelList = wdtStockoutOrderTradeService.getBySyncRequest(syncRequest);
        if(syncModelList.size() == 0){
            busSyncConfigService.modifyGmtNextSyncByCode(syncRequest.getEndTime(),BusSyncConfigEnum.WDT_STOCKSOUT_ORDER_SYNC.code());
            return;
        }
        SyncResult syncResult = wholeHeadService.stockoutOrderTradeSync(syncModelList);
        if(syncResult.isSuccess()){
            busSyncConfigService.modifyGmtNextSyncByCode(syncRequest.getEndTime(),BusSyncConfigEnum.WDT_STOCKSOUT_ORDER_SYNC.code());
        }else {
            log.error("旺店通销售出库单同步至商务销售订单错误，原因："+syncResult.getDetailMessage());
        }
    }
}
