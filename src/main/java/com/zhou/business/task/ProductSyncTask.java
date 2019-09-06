package com.zhou.business.task;

import com.zhou.business.dal.business.entity.ProductDs;
import com.zhou.business.dal.toolmall.entity.BusSyncConfig;
import com.zhou.business.enums.BusSyncConfigEnum;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.BusSyncConfigService;
import com.zhou.business.service.ProductDsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 18:26
 */
@Slf4j
@Component
public class ProductSyncTask {

    @Autowired
    private BusSyncConfigService busSyncConfigService;

    @Autowired
    private ProductDsService productDsService;

    @Scheduled(cron = "0 0/30 * ? * ?")
    private void execute() {

        BusSyncConfig busSyncConfig = busSyncConfigService.getByCode(BusSyncConfigEnum.BUSINESS_PRODUCT_SYNC.code());
        if(busSyncConfig == null){
            return;
        }
        Date startTime = busSyncConfig.getGmtNextSync();
        Date endTime = new Date();
        List<ProductDs> productDsList = productDsService.getByUpdateDate(startTime,endTime);
        if(productDsList.size()>0){
            SyncResult syncResult = productDsService.pushToWdt(productDsList);
            if(syncResult.isSuccess()){
                busSyncConfigService.modifyGmtNextSyncByCode(syncResult.getMaxModifyDate(),BusSyncConfigEnum.BUSINESS_PRODUCT_SYNC.code());
            }else {
                log.error("商务系统商品同步错误，原因："+syncResult.getDetailMessage());
            }
        }
    }
}
