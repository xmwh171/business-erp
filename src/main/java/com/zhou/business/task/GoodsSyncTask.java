package com.zhou.business.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 18:26
 */
@Component
public class GoodsSyncTask {

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void goodsSync() {

    }
}
