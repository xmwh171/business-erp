package com.zhou.business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 15:21
 */
@Configuration
public class WdtConfig {

    @Value("${wdt.sid}")
    private String sid;

    @Value("${wdt.appkey}")
    private String appkey;

    @Value("${wdt.appsecret}")
    private String appsecret;

    @Value("${wdt.wangdiantongurl}")
    private String wangdiantongurl;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getWangdiantongurl() {
        return wangdiantongurl;
    }

    public void setWangdiantongurl(String wangdiantongurl) {
        this.wangdiantongurl = wangdiantongurl;
    }
}
