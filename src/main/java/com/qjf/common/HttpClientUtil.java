package com.qjf.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author:Tin
 * @Date: create in 2018/2/26 18:10
 * @Description:
 */
public class HttpClientUtil {

    public static String doGet(String url, String charset) {
        HttpGet httpGet = null;
        String result = null;

        try {
            if(StringUtils.isBlank(charset))
                charset = "UTF-8";

            SSLClient httpClient = new SSLClient();
            httpGet = new HttpGet(url);

            HttpResponse response2 = httpClient.execute(httpGet);
            if(response2 != null) {
                HttpEntity resEntity = response2.getEntity();
                if(resEntity != null)
                    result = EntityUtils.toString(resEntity, charset);
            }
        } catch (Exception var13) {
            var13.printStackTrace();
            Map map = new HashMap<>();
            map.put("errmsg",var13.getMessage());
            map.put("errcode",1);
            result = JSON.toJSONString(map);
        } finally {
            if(null != httpGet)
                httpGet.releaseConnection();
        }

        return result;
    }

    public static String doPost(String url, Map<String, String> map, String charset) {
        HttpPost httpPost = null;
        String result = null;
        try {
            if(StringUtils.isBlank(charset))
               charset = "UTF-8";

            SSLClient httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            ArrayList ex = new ArrayList();
            Iterator iterator = map.entrySet().iterator();

            while(iterator.hasNext()) {
                Map.Entry response = (Map.Entry)iterator.next();
                ex.add(new BasicNameValuePair((String)response.getKey(), (String)response.getValue()));
            }

            if(ex.size() > 0) {
                UrlEncodedFormEntity response1 = new UrlEncodedFormEntity(ex, charset);
                httpPost.setEntity(response1);
            }

            HttpResponse response2 = httpClient.execute(httpPost);
            if(response2 != null) {
                HttpEntity resEntity = response2.getEntity();
                if(resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception var13) {
            var13.printStackTrace();
            result = var13.getMessage();
        } finally {
            httpPost.releaseConnection();
        }

        return result;
    }

    public static String doPostJson(String url, Map<String, Object> map, String charset) {
        HttpPost httpPost = null;
        String result = null;
        try {
            if(StringUtils.isBlank(charset))
                charset = "UTF-8";

            SSLClient httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");


            String jsonStr = JSON.toJSONString(map);
            StringEntity se = new StringEntity(jsonStr,charset);
            httpPost.setEntity(se);

            HttpResponse response2 = httpClient.execute(httpPost);
            if(response2 != null) {
                HttpEntity resEntity = response2.getEntity();
                if(resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception var13) {
            var13.printStackTrace();
            result = var13.getMessage();
        } finally {
            httpPost.releaseConnection();
        }

        return result;
    }

}
