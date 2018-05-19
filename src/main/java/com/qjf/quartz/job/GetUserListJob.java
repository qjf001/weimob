package com.qjf.quartz.job;

import com.qjf.common.WeimobTokenRequester;
import com.qjf.demo.entity.WeimobUser;
import com.qjf.demo.service.WeimobUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Tin
 * @Date: create in 2018/3/14 17:41
 * @Description: 定时刷新token，每110分钟刷新一次
 */
public class GetUserListJob extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(GetUserListJob.class);

    private static int pagesize=10;

    @Resource
    private WeimobUserService weimobUserService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        try {
            // 查询本地数据库，create_time最大的那个时间
            long create_time = weimobUserService.selectMaxCreateTime();

            // 设置查询参数，只能提供 >= 的这种按照时间的查询方式
            Map<String,Object> param = new HashMap();
            param.put("pageindex",1);
            param.put("pagesize",pagesize);//能否支持多大？ 默认值为5
            param.put("sortby",6);//排序字段（0默认，可用余额 1可用余额 2可用积分 3累计消费 4消费次数 5上次消费时间 6创建时间）
            param.put("asc_or_desc",0);//升序还是降序（0=升序，1=降序）
            param.put("create_time",create_time+1000);// >= create_time

            logger.info("user list search param = "+param);

            Map<String,Object> result = WeimobTokenRequester.getUserList(param);
            if(null!=result){
                int totalCount = (Integer)result.get("total_count");
                if(totalCount > 0){
                    List<Map<String,Object>> items = (List<Map<String,Object>>)result.get("items");
                    saveData(items);
                }

                int totalPage = 1;
                if(totalCount%pagesize!=0)
                    totalPage = totalCount/pagesize+1;
                if(totalPage > 1)
                    getMorePage(totalPage,param);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void getMorePage(int totalPage, Map<String,Object> param){

        for(int i=2 ;i<=totalPage;i++){
            param.put("pageindex",i);
            Map<String,Object> result = WeimobTokenRequester.getUserList(param);
            if(null!=result){
                List<Map<String,Object>> items = (List<Map<String,Object>>)result.get("items");
                saveData(items);
            }
        }
    }

    private void saveData(List<Map<String,Object>> items){
        for(Map<String,Object> map :items){
            try {
                WeimobUser wu = new WeimobUser();
                wu.setOpenid((String)map.get("openid"));
                wu.setWeimobOpenid((String)map.get("weimob_openid"));
                wu.setCustomerNo((String)map.get("customer_no"));
                wu.setQrcodeUrl((String)map.get("qrcode_url"));
                wu.setBarcodeUrl((String)map.get("barcode_url"));
                wu.setTags((String)map.get("tags"));
                wu.setIsFans(((Boolean)map.get("is_fans")).toString());
                wu.setCustomerType((String)map.get("customer_type"));
                wu.setLevelname((String)map.get("levelname"));
                wu.setMenbercardId((String)map.get("menbercard_id"));
                wu.setCurrentGrowthValue((Integer)map.get("current_growth_value"));
                wu.setWxcodeStatus((Integer)map.get("wxcode_status"));
                wu.setWxcode((String)map.get("wxcode"));
                wu.setRegisterDate( Long.valueOf(map.get("register_date").toString()));
                wu.setCardValidityType((String)map.get("card_validity_type"));
                wu.setCardValidityTime(Long.valueOf(map.get("card_validity_time").toString()));
                wu.setName((String)map.get("name"));
                wu.setNickname((String)map.get("nickname"));
                wu.setPortraitUrl((String)map.get("portrait_url"));
                wu.setPhone((String)map.get("phone"));
                wu.setSex((String)map.get("sex"));
                wu.setBirthDay(Long.valueOf(map.get("birth_day").toString()));
                wu.setTotalPoints(Integer.valueOf(map.get("total_points").toString()));
                wu.setCurrentPoints(Integer.valueOf(map.get("current_points").toString()));
                wu.setCurrentAmount(new BigDecimal(map.get("current_amount").toString()));
                wu.setTotalTransactionAmount(new BigDecimal(map.get("total_transaction_amount").toString()));
                wu.setTotalTransactionCount(Integer.valueOf(map.get("total_transaction_count").toString()));
                wu.setAverageAmount(new BigDecimal(map.get("average_amount").toString()));
                wu.setLastTransactionTime(Long.valueOf(map.get("last_transaction_time").toString()));
                wu.setCreateTime(Long.valueOf(map.get("create_time").toString()));
                wu.setUpdateTime(Long.valueOf(map.get("update_time").toString()));
                weimobUserService.insert(wu);
            } catch (Exception e) {
                logger.error("weimob_openid="+map.get("openid")+"  errorMsg="+e.getMessage());
            }
        }
    }
}
