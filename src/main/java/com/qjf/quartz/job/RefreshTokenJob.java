package com.qjf.quartz.job;

import com.alibaba.fastjson.JSON;
import com.qjf.common.AccessTokenHelper;
import com.qjf.common.HttpClientUtil;
import com.qjf.common.WeimobTokenRequester;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tin
 * @Date: create in 2018/3/14 17:41
 * @Description: 定时刷新token，每110分钟刷新一次
 */
public class RefreshTokenJob extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(RefreshTokenJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Map<String,Object> map = AccessTokenHelper.getAccessTokenMap();
            if(null != map){
                /**
                 名称	是否必选	参数值	参数释义
                 client_id	是		创建应用时获得。
                 client_secret	是		创建应用时获得。
                 grant_type	是	refresh_token	授权类型 ，值为refresh_token
                 refresh_token	是		上一步中返回的refresh_token
                 state	可选		自定义state
                 */
                String refresh_token = map.get("refresh_token").toString();
                Map<String,Object> param = new HashMap<>();
                param.put("client_id", WeimobTokenRequester.client_id);
                param.put("client_secret",WeimobTokenRequester.client_secret);
                param.put("grant_type","refresh_token");
                param.put("refresh_token",refresh_token);
                param.put("state","s");

                String res = HttpClientUtil.doPostJson(WeimobTokenRequester.refresh_token_url+refresh_token,param,null);
                Map<String,Object> newTokenMap =  (Map)JSON.parse(res);
                newTokenMap.put("createtime",System.currentTimeMillis());
                AccessTokenHelper.refreshSetToken(newTokenMap);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
