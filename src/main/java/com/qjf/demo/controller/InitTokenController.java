package com.qjf.demo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Tin
 * @Date: create in 2018/3/14 18:22
 * @Description:
 */
@Controller
@RequestMapping("admin/initToken")
public class InitTokenController extends BasicController{

    private static Logger logger = LoggerFactory.getLogger(InitTokenController.class);

    /**
     * @Author:QJF
     * @Date: 2018-01-15
     * @Description: 列表页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return COMMON_LIST;
    }

    /**
     * 获取缓存中的token信息
     * */
    @RequestMapping(value = "listData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public MyPage<Map<String,Object>> getToken(Page<Map<String,Object>> page){

        try {
            List<Map<String,Object>> list = new ArrayList<>();
            Map map = AccessTokenHelper.getAccessTokenMap();
            if(null == map)
                map = new HashMap();
            else{
                map.put("id",WeimobTokenRequester.client_id);
                int expires_in = (Integer)map.get("expires_in");
                map.put("expires_in_str",expires_in/3600+"小时"+expires_in%3600/60+"分钟");
                map.put("createtime",new Timestamp((Long)map.get("createtime")));
                int rte = (Integer)map.get("refresh_token_expires_in");
                map.put("refresh_token_expires_str",rte/(3600*24)+"天"+rte%(3600*24)/3600+"小时"+rte%(60)+"分钟");
            }

            list.add(map);
            page.setRecords(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new MyPage(page);
    }

    /**
     * 初始化缓存token
     * */
    @RequestMapping("init")
    @ResponseBody
    public Map init(String code){
        ResultMap rm = new ResultMap();
        if(StringUtils.isBlank(code) || code.length()!=6)
            return rm;
        try {
            Map<String,Object> tokenMap = WeimobTokenRequester.getToken(code);
            // 要处理错误信息，返回的信息是json格式但是错误提示信息
            if(null==tokenMap)
                return rm;
            AccessTokenHelper.initAccessToken(tokenMap);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
    }
}
