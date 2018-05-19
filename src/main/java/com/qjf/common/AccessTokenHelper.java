package com.qjf.common;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/14.
 * 通用accessToken缓存方案：
 * 缓存容器为 map ,key 为 WeimobTokenRequester.getAppId() , value 为  map（保存有token的有效信息）
 */
public class AccessTokenHelper {

    /**
     * access_token	string		Access token
      token_type	string	Bearer	Access token的类型目前只支持bearer
      expires_in	number	7200（表示7200秒后过期）	Access token过期时间
      refresh_token	string		Refresh token，可用来刷新access_token
      refresh_token_expires_in	number	默认7天	Refresh token有效期
      scope	String	默认default	授权范围
      business_id	String		微盟商户id
      public_account_id String
     createtime      int
     * \**/
    // 返回token 允许为null;
    public static String  getAccessTokenStr() {
        Element e = getCache().get(WeimobTokenRequester.getAppId());
        if(null==e || null==e.getObjectValue())
            return null;
        Map<String,Object> tokenMap = (Map<String,Object>)e.getObjectValue();
        return tokenMap.get("access_token").toString();
    }

    public static Map<String,Object> getAccessTokenMap() {
        System.out.println("token cache size ="+getCache().getKeys().size());
        Element e = getCache().get(WeimobTokenRequester.getAppId());
        if(null==e || null==e.getObjectValue())
            return null;
        Map map = new HashMap<>();
        map.putAll((Map<String,Object>)e.getObjectValue());
        return map;
    }

    // 刷新到token后缓存起来
    public static void refreshSetToken(Map<String,Object> tokenMap) {
        Element e = new Element(WeimobTokenRequester.getAppId(),tokenMap);
        Ehcache cache = getCache();
        cache.put(e);
        cache.flush();
    }

    // 对外部提供初始化缓存token的方式，可以在后台操作
    public static void initAccessToken(Map<String,Object> tokenMap) {
        Element e = new Element(WeimobTokenRequester.getAppId(),tokenMap);
        Ehcache cache = getCache();
        cache.put(e);
        cache.flush();
    }

    public void clearAccessToken()
    {
        getCache().removeAll();
    }

    private static Ehcache getCache(){
        CacheManager cacheManager = (CacheManager)SpringUtil.getBean("ehcacheManager");
        return cacheManager.getEhcache("weimob.access_token");
    }

    public static void main(String[] args) {
    }
}
