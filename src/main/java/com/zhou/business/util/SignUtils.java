package com.zhou.business.util;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @Description 签名工具类
 * @Author xiaohu
 * @Date 2018/10/18 13:24
 */
public class SignUtils {

    /**
     *
     * 新的md5签名，尾部放secret。
     *
     * @param secret
     *            分配给您的APP_SECRET
     *
     */

    public static String md5Signature(TreeMap<String, String> params, String secret) {

        String result = null;

        StringBuffer orgin = getBeforeSign(params, secret);

        if (orgin == null)

            return result;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));

        } catch (Exception e) {

            throw new RuntimeException("sign error !");

        }

        return result;

    }

    // 过滤特殊字符
    public static String StringFilter(String   str)   throws PatternSyntaxException {
        // 清除掉所有特殊字符
        String regEx = "[+]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }



    /**
     *
     * 添加参数的封装方法
     *
     */

    private static StringBuffer getBeforeSign(TreeMap<String, String> params, String secret) {

        if (params == null) {
            return null;
        }

        StringBuffer orgin = new StringBuffer();
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(params);

        Iterator<String> iter = treeMap.keySet().iterator();
        while (iter.hasNext()) {

            String key = (String) iter.next();
            String value = treeMap.get(key);

            int keylen = key.length();
            String keypattern = "00";
            java.text.DecimalFormat keydf = new java.text.DecimalFormat(keypattern);
            String keylenstr = keydf.format(keylen);

            int valuelen = value.length();
            String valuepattern = "0000";
            java.text.DecimalFormat valuedf = new java.text.DecimalFormat(valuepattern);
            String valuelenstr = valuedf.format(valuelen);

            if (orgin != null && orgin.toString().length() > 0)
                orgin.append(";");

            orgin.append(keylenstr).append("-").append(key).append(":").append(valuelenstr).append("-").append(StringFilter(value));

        }

        orgin.append(secret);
        return orgin;

    }

    /**
     *
     * 二行制转字符串
     *
     */

    private static String byte2hex(byte[] b) {

        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1){
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }

        return hs.toString().toLowerCase();

    }

}
