package com.zhou.business.task;

import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.enums.BusSyncConfigEnum;
import com.zhou.business.request.WdtStockinOrderRefundSyncRequest;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.BusSyncConfigService;
import com.zhou.business.service.WdtStockinOrderRefundService;
import com.zhou.business.service.WholeHeadDsService;
import com.zhou.business.util.ListUtils;
import com.zhou.business.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Description 旺店通销售退货入库单同步至商务销售订单定时任务
 * @Author xiaohu
 * @Date 2019/9/5 9:49
 */
@Slf4j
@Component
public class WdtStockinOrderRefundPushTask {


    @Autowired
    private BusSyncConfigService busSyncConfigService;

    @Autowired
    private WdtStockinOrderRefundService wdtStockinOrderRefundService;

    @Autowired
    private WholeHeadDsService wholeHeadDsService;

    @Scheduled(cron = "0 0/2 * ? * ?")
    private void execute() {

        BusSyncConfig busSyncConfig = busSyncConfigService.getByCode(BusSyncConfigEnum.WDT_STOCKIN_ORDER_REFUND_SYNC.code());
        if(busSyncConfig == null){
            return;
        }
        WdtStockinOrderRefundSyncRequest syncRequest = new WdtStockinOrderRefundSyncRequest();
        List<String> shopNoList = new ArrayList<>();
        String properties = busSyncConfig.getProperties();
        Map<String, String> propertiesMap = new HashMap<>();
        if(StringUtils.notEmpty(properties)){
            propertiesMap = BusSyncConfig.parseProperties(properties);
        }
        String shopNos = propertiesMap.get("shop_no");
        if(StringUtils.notEmpty(shopNos)){
            shopNoList.addAll(ListUtils.toList(StringUtils.split(shopNos,"、")));
        }
        syncRequest.setStartTime(busSyncConfig.getGmtNextSync());
        syncRequest.setEndTime(new Date());
        syncRequest.setShopNoList(shopNoList);
        List<WdtStockinOrderRefundSyncModel> syncModelList = wdtStockinOrderRefundService.getBySyncRequest(syncRequest);
        if(syncModelList.size() == 0){
            busSyncConfigService.modifyGmtNextSyncByCode(syncRequest.getEndTime(),BusSyncConfigEnum.WDT_STOCKIN_ORDER_REFUND_SYNC.code());
            return;
        }
        SyncResult syncResult = wholeHeadDsService.stockinOrderRefundSync(syncModelList);
        if(syncResult.isSuccess()){
            busSyncConfigService.modifyGmtNextSyncByCode(syncRequest.getEndTime(),BusSyncConfigEnum.WDT_STOCKIN_ORDER_REFUND_SYNC.code());
        }else {
            log.error("旺店通销售退货入库单同步至商务销售订单错误，原因："+syncResult.getDetailMessage());
        }
    }
}
