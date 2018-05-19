package com.qjf.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geli on 2018/3/13.
 */
public class WeimobTokenRequester {

    private static Logger logger = LoggerFactory.getLogger(WeimobTokenRequester.class);

    public static final String client_id = "868422D1B84CC1676806A4CAACCAE2FC";
    public static final String client_secret = "6E1E60D33C25E3769EF52B05F7ECDBD1";

    // 刷新token ,post
    public static String refresh_token_url="https://dopen.weimob.com/fuwu/b/oauth2/token?grant_type=refresh_token&client_id="+client_id+"&client_secret="+client_secret+"&refresh_token=";

    // post 请求
    public static String userList_url = "https://dopen.weimob.com/api/1_0/WPMemberCard/MemberOpenPlatformService/GetMemberInfoPageListAndTotal?accesstoken=";

    // post
    public static String orderDetailList_url="https://dopen.weimob.com/api/1_0/wangpu/Order/FullInfoGetPaging?accesstoken=";

    public static String getAppId(){
        return client_id;
    }

    // post 请求 ,redirect_uri 回调地址，是在你选择好需要授权的公众号后跳转的地址，请确保你能在该地址进行数据获取操作。
    public static String getTokenUrl(String code){
        return "https://dopen.weimob.com/fuwu/b/oauth2/token?code="+code+"&grant_type=authorization_code&client_id="+client_id+"&client_secret="+client_secret+"&redirect_uri=https://www.innzoo.cn";
    }

    public static Map<String,Object> getToken(String code){
        try {
            String str =  HttpClientUtil.doPost(WeimobTokenRequester.getTokenUrl(code),new HashMap<>(),"");
            logger.info("~~~~~~~~~~~~~getToken str="+str);
            Map<String,Object> result = (Map) JSON.parse(str);
            // 如果返回的是错误的信息，则直接返回null
            if(null != result.get("error")){
                logger.error(result.toString());
                return null;
            }

            result.put("createtime",System.currentTimeMillis());
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    /**  请求参数，格式为json
     参数	类型	是否必须	默认值	描述
     sex	int	否	0	性别（不限=0,男=1,女=2）
     sortby	int	否		排序字段（0默认，可用余额 1可用余额 2可用积分 3累计消费 4消费次数 5上次消费时间 6创建时间）
     asc_or_desc	int	否	0	升序还是降序（0=升序，1=降序）
     member_level	string	否		客户类型编号
     province	string	否		省
     city	string	否		市
     consuming_count_min	int	否	0	交易笔数-小
     consuming_count_max	int	否	0	交易笔数-大
     allconsuming_amount_min	decimal	否	0	交易额范围-小
     allconsuming_amount_max	decimal	否	0	交易额范围-大
     lastconsuming_time_min	long?	否		最后一次交易时间范围-小
     lastconsuming_time_max	long?	否		最后一次交易时间范围-大
     is_need_tags_info	bool	否	false	是否需要加载客户标签
     pageindex	int	是	1	从第几页开始
     pagesize	int	是	5	每页数量
     nickname	string	否		昵称
     menbercard_id	string	否		卡号
     phone	string	否		手机号
     name	string	否		姓名
     create_time	long?	否		创建时间（主要用于做增量查询 查询规则>=创建时间）
     register_date	long?	否		成为会员时间（主要用于做增量查询 查询规则>=成为会员时间）
     update_time	long?	否		更新时间（主要用于做增量查询 查询规则>=更新时间）
     is_fans	bool?	否	null	查询粉丝（不填为全部,true为仅查询粉丝 false为仅查询非粉丝）
     */
    /** errorcode!=0表示错误
     * {
     "code": {
     "errorcode": "错误码",
     "errmsg": "错误提示信息"
     },
     "data": {}
     * */
    public static Map<String,Object> getUserListTest(){
        Map<String,Object> param = new HashMap();
        param.put("pageindex",1);
        param.put("pagesize",100);
        String str = HttpClientUtil.doPostJson(userList_url+AccessTokenHelper.getAccessTokenStr(),param,null);
        logger.info("~~~~~~~~~~~~~user List str="+str);
        Map<String,Object> result = (Map) JSON.parse(str);
        Map<String,Object> codeMap = (Map<String,Object>)result.get("code");
        if(!"0".equals(codeMap.get("errcode").toString())){
            logger.error(result.toString());
            return null;
        }
        return (Map<String,Object>)result.get("data");
    }

    public static Map<String,Object> getUserList(Map<String,Object> param){
        String token = AccessTokenHelper.getAccessTokenStr();
        if(StringUtils.isBlank(token))
        {
            logger.error(" access_token is not null ");
            return null;
        }
        String str = HttpClientUtil.doPostJson(userList_url+AccessTokenHelper.getAccessTokenStr(),param,null);
        logger.info("~~~~~~~~~~~~~user List str="+str);
        Map<String,Object> result = (Map) JSON.parse(str);
        Map<String,Object> codeMap = (Map<String,Object>)result.get("code");
        if(!"0".equals(codeMap.get("errcode").toString())){
            logger.error(result.toString());
            return null;
        }
        return (Map<String,Object>)result.get("data");
    }

    public static Map<String,Object> getOrderDetailList(Map<String,Object> param){
        String token = AccessTokenHelper.getAccessTokenStr();
        if(StringUtils.isBlank(token))
        {
            logger.error(" access_token is not null ");
            return null;
        }
        String str = HttpClientUtil.doPostJson(orderDetailList_url+AccessTokenHelper.getAccessTokenStr(),param,null);
        logger.info("~~~~~~~~~~~~~orderDetai List str="+str);
        Map<String,Object> result = (Map) JSON.parse(str);
        Map<String,Object> codeMap = (Map<String,Object>)result.get("code");
        if(!"0".equals(codeMap.get("errcode").toString())){
            logger.error(result.toString());
            return null;
        }
        return (Map<String,Object>)result.get("data");
    }

    public static void main(String[] args) {

    }


}
