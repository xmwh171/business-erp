package com.zhou.business.wdtclient;

import com.alibaba.fastjson.JSONObject;
import com.zhou.business.config.WdtConfig;
import com.zhou.business.util.HttpUtils;
import com.zhou.business.util.SignUtils;
import com.zhou.business.wdtclient.model.WdtGoodsPushInfo;
import com.zhou.business.wdtclient.model.WdtStockinOrder;
import com.zhou.business.wdtclient.model.WdtStockoutOrderInfo;
import com.zhou.business.wdtclient.result.WdtBaseResult;
import com.zhou.business.wdtclient.result.WdtStockinOrderPushResult;
import com.zhou.business.wdtclient.result.WdtStockoutOrderPushResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/3 15:20
 */
@Service
public class WdtApiIntegration {

    @Autowired
    private WdtConfig wdtConfig;

    // 过滤特殊字符
    public  String StringFilter(String str)   throws PatternSyntaxException {
        // 清除掉所有特殊字符
        String regEx = "[+&]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    /**
     * 创建货品档案
     * @param
     * @return
     * @throws Exception
     */
    public WdtBaseResult goodsPush(List<WdtGoodsPushInfo> wdtGoodsPushInfoList) throws Exception {
        WdtBaseResult wdtBaseResult = new WdtBaseResult();
        TreeMap<String, String> paramsMap = new TreeMap<String, String>();
        paramsMap.put("sid", wdtConfig.getSid());
        paramsMap.put("appkey", wdtConfig.getAppkey());
        paramsMap.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        paramsMap.put("goods_list", StringFilter(JSONObject.toJSONString(wdtGoodsPushInfoList).replace("+","＋")));
        String sign = SignUtils.md5Signature(paramsMap, wdtConfig.getAppsecret());
        paramsMap.put("sign", sign);

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(e.getValue());
        }
        String postData = "";
        postData = param.toString().substring(1);

        String urlStr = wdtConfig.getWangdiantongurl() + "/openapi2/goods_push.php";
        String result = HttpUtils.getResult(urlStr, postData);
        if (result == null) {
            wdtBaseResult.setSuccess(false);
            return wdtBaseResult;
        }
        WdtBaseResult pushResult = JSONObject.parseObject(result.toString(), WdtBaseResult.class);
        if(pushResult == null){
            wdtBaseResult.setSuccess(false);
            return wdtBaseResult;
        }
        if(pushResult.getCode()!= 0){
            pushResult.setSuccess(false);
            return pushResult;
        }
        pushResult.setSuccess(true);
        return pushResult;
    }


    /**
     * 其他入库单创建
     * @param wdtStockinOrder
     * @return
     */
    public WdtStockinOrderPushResult stockinOrderPush(WdtStockinOrder wdtStockinOrder) throws IOException {
        WdtStockinOrderPushResult pushResult = new WdtStockinOrderPushResult();
        TreeMap<String, String> paramsMap = new TreeMap<String, String>();
        paramsMap.put("sid", wdtConfig.getSid());
        paramsMap.put("appkey", wdtConfig.getAppkey());
        paramsMap.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        paramsMap.put("stockin_info",JSONObject.toJSONString(wdtStockinOrder));
        String sign = SignUtils.md5Signature(paramsMap, wdtConfig.getAppsecret());
        paramsMap.put("sign", sign);

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(e.getValue());
        }
        String postData = "";
        postData = param.toString().substring(1);

        String urlStr = wdtConfig.getWangdiantongurl() + "/openapi2/stockin_order_push.php";
        String result = HttpUtils.getResult(urlStr, postData);
        if (result == null) {
            pushResult.setSuccess(false);
            return pushResult;
        }
        pushResult = JSONObject.parseObject(result.toString(), WdtStockinOrderPushResult.class);
        if(pushResult.getCode()!= 0){
            pushResult.setSuccess(false);
            return pushResult;
        }
        pushResult.setSuccess(true);
        return pushResult;
    }


    /**
     * 其他出库单创建
     * @param wdtStockoutOrderInfo
     * @return
     */
    public WdtStockoutOrderPushResult stockoutOrderPush(WdtStockoutOrderInfo wdtStockoutOrderInfo) throws IOException {
        WdtStockoutOrderPushResult pushResult = new WdtStockoutOrderPushResult();
        TreeMap<String, String> paramsMap = new TreeMap<String, String>();
        paramsMap.put("sid", wdtConfig.getSid());
        paramsMap.put("appkey", wdtConfig.getAppkey());
        paramsMap.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        paramsMap.put("stockout_info",JSONObject.toJSONString(wdtStockoutOrderInfo));
        String sign = SignUtils.md5Signature(paramsMap, wdtConfig.getAppsecret());
        paramsMap.put("sign", sign);

        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> it = paramsMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(e.getValue());
        }
        String postData = "";
        postData = param.toString().substring(1);

        String urlStr = wdtConfig.getWangdiantongurl() + "/openapi2/stockout_order_push.php";
        String result = HttpUtils.getResult(urlStr, postData);
        if (result == null) {
            pushResult.setSuccess(false);
            return pushResult;
        }
        pushResult = JSONObject.parseObject(result.toString(), WdtStockoutOrderPushResult.class);
        if(pushResult.getCode()!= 0){
            pushResult.setSuccess(false);
            return pushResult;
        }
        pushResult.setSuccess(true);
        return pushResult;
    }


}
