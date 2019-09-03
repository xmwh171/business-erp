package com.zhou.business.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description http工具类
 * @Author xiaohu
 * @Date 2018/10/18 16:19
 */
@Slf4j
public class HttpUtils {

    /** 连接到TOP服务器并获取数据 */

    public static String getResult(String urlStr, String content) {

        URL url = null;

        HttpURLConnection connection = null;

        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content.getBytes("utf-8"));
            out.flush();
            out.close();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            if (connection.getResponseCode() == 200) {
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
            }
            reader.close();
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求"+urlStr+"错误"+e.getMessage(),e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;

    }

}
