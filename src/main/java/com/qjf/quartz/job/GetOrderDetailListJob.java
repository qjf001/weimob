package com.qjf.quartz.job;

import com.alibaba.fastjson.JSON;
import com.qjf.common.WeimobTokenRequester;
import com.qjf.demo.entity.WeimobOrder;
import com.qjf.demo.entity.WeimobOrderDetail;
import com.qjf.demo.service.WeimobOrderDetailService;
import com.qjf.demo.service.WeimobOrderService;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Tin
 * @Date: create in 2018/3/15 13:11
 * @Description:
 */
public class GetOrderDetailListJob extends QuartzJobBean {

    private static Logger logger = LoggerFactory.getLogger(GetOrderDetailListJob.class);

    private static int pageSize = 50;

    @Resource
    private WeimobOrderService weimobOrderService;

    @Resource
    private WeimobOrderDetailService weimobOrderDetailService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String create_begin_time = "2010-01-01 00:00:00";
        // 查询本地数据库，create_time最大的那个时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String maxCreateTime = weimobOrderService.selectMaxCreateTime();
        if(!StringUtils.isBlank(maxCreateTime) && maxCreateTime.trim().length()==19)
        {
            try {
                Date d = sdf.parse(maxCreateTime);
                d =  new Date(d.getTime()+1000);
                create_begin_time = sdf.format(d);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        String create_end_time = sdf.format(new Date());

        //
        Map<String,Object> param = new HashMap();
        param.put("page_no",1);
        param.put("page_size",pageSize);//最大支持50
        param.put("create_begin_time",create_begin_time);// yyyy-MM-dd HH:mm:ss
        param.put("create_end_time",create_end_time);// yyyy-MM-dd HH:mm:ss

        Map<String,Object> result = WeimobTokenRequester.getOrderDetailList(param);
        if(null!=result){
            List<Map<String,Object>> items =  (List<Map<String,Object>>)result.get("page_data");
            saveToDb(items);
            Integer pageCount = (Integer)result.get("page_count");
            getMorePage( pageCount, create_begin_time, create_end_time);
        }
    }

    private void saveToDb(List<Map<String,Object>> items){

        for(Map<String,Object> item :items){
            try {
                WeimobOrder o = new WeimobOrder();
                o.setActivityType((Integer)item.get("activity_type"));
                o.setIsSupplierDelivery(((Boolean)item.get("is_supplier_delivery")).toString());
                Object order_id = item.get("order_id");
                o.setOrderId(null==order_id?null:Integer.valueOf(order_id.toString()));
                o.setOrderNo((String)item.get("order_no"));
                o.setOrderSource((String)item.get("order_source"));
                Object order_type = item.get("order_type");
                o.setOrderType(null==order_type?null:Integer.valueOf(order_type.toString()));
                Object order_status = item.get("order_status");
                o.setOrderStatus(null==order_status?null:Integer.valueOf(order_status.toString()));
                o.setCreateTime((String)item.get("create_time"));
                o.setCreateMan((String)item.get("create_man"));
                o.setUpdateTime((String)item.get("update_time"));
                o.setUpdateMan((String)item.get("update_man"));
                o.setIsDelete(((Boolean)item.get("is_delete")).toString());
                o.setDiscountAmount((BigDecimal)item.get("discount_amount"));
                o.setDiscountDetail((String)item.get("discount_detail"));
                o.setCouponAmount((BigDecimal)item.get("coupon_amount"));
                o.setCouponsNo( (String)item.get("coupons_no"));
                Object point_use = item.get("point_use");
                o.setPointUse(null==point_use?null:Integer.valueOf(point_use.toString()));
                o.setPointAmount((BigDecimal)item.get("point_amount"));
                o.setBalanceAmount((BigDecimal)item.get("balance_amount"));
                o.setRealAmount((BigDecimal)item.get("real_amount"));
                o.setIsOnlinepay(((Boolean)item.get("is_onlinepay")).toString());
                Object pay_status = item.get("pay_status");
                o.setPayStatus(null==pay_status?null:Integer.valueOf(pay_status.toString()));
                o.setPayTime((String)item.get("pay_time"));
                o.setPaymentId((String)item.get("payment_id"));
                o.setPaymentCode((String)item.get("payment_code"));
                o.setPaymentName((String)item.get("payment_name"));
                o.setPaymentThirdno((String)item.get("payment_thirdno"));
                o.setDeliveryAmount((BigDecimal)item.get("delivery_amount"));
                Object delivery_status = item.get("delivery_status");
                o.setDeliveryStatus(null==delivery_status?null:Integer.valueOf(delivery_status.toString()));
                o.setDeliveryType((String)item.get("delivery_type"));
                o.setCarrierName((String)item.get("carrier_name"));
                o.setExpressNo((String)item.get("express_no"));
                o.setReceiverAddress((String)item.get("receiver_address"));
                o.setReceiverName((String)item.get("receiver_name"));
                o.setReceiverTel((String)item.get("receiver_tel"));
                o.setSenderAddress((String)item.get("sender_address"));
                o.setSenderName((String)item.get("sender_name"));
                o.setSenderTel((String)item.get("sender_tel"));
                o.setDeliveryTime((String)item.get("delivery_time"));
                o.setReceiveTime((String)item.get("receive_time"));
                o.setOrderFlag((Integer)item.get("order_flag"));
                o.setOrderFlagMemo((String)item.get("order_flag_memo"));
                o.setRemark((String)item.get("remark"));
                Object sku_qty = item.get("sku_qty");
                o.setSkuQty(null==sku_qty?null:Integer.valueOf(sku_qty.toString()));
                o.setGoodsAmount((BigDecimal)item.get("goods_amount"));
                o.setMemberId((String)item.get("member_id"));
                o.setOpenId((String)item.get("open_id"));
                Object user_ztInfo = item.get("user_ztInfo");//用户自提信息JSON字符串(用户自提信息JSON字符串)
                o.setUserZtinfo(JSON.toJSONString(user_ztInfo));
                o.setZtCode((String)item.get("zt_code"));
                o.setZtQrcode((String)item.get("zt_qrCode"));
                Object zt_shopSetId = item.get("zt_shopSetId");
                o.setZtShopsetid(null==zt_shopSetId?null:Integer.valueOf(zt_shopSetId.toString()));
                o.setHxStatus(((Boolean)item.get("hx_status")).toString());
                o.setHxBy((String)item.get("hx_by"));
                Object distribution_timeType = item.get("distribution_timeType");
                o.setDistributionTimetype(null==distribution_timeType?null:Integer.valueOf(distribution_timeType.toString()));
                o.setMechantDeliverytime((String)item.get("mechant_deliveryTime"));
                Object distribution_type = item.get("distribution_type");
                o.setDistributionType(null==distribution_type?null:Integer.valueOf(distribution_type.toString()));
                Object pt_status = item.get("pt_status");
                o.setPtStatus(null==pt_status?null:Integer.valueOf(pt_status.toString()));
                o.setPacks(JSON.toJSONString(item.get("packs")));
                o.setPaymentDetails(JSON.toJSONString(item.get("payment_details")));
                o.setFansInfo(JSON.toJSONString(item.get("fans_info")));
                o.setDistributionInfo(JSON.toJSONString(item.get("distribution_info")));
                o.setReceiverRegion(JSON.toJSONString(item.get("receiver_region")));
                o.setOrderDetails(JSON.toJSONString(item.get("order_details")));
                o.setReturnDetail(JSON.toJSONString(item.get("return_detail")));
                weimobOrderService.insert(o);

                if(!StringUtils.isBlank(o.getOrderDetails())){
                    System.out.println(" order detail =" + o.getOrderDetails());
                    List<Map<String,Object>> details = (List<Map<String,Object>>)JSON.parse(o.getOrderDetails());
                    System.out.println(" detail parse to list  = "+ details);
                    for(Map<String,Object> map : details){
                        System.out.println(" detail = "+ map);
                        WeimobOrderDetail d = new WeimobOrderDetail();
                        d.setOrderId(Long.valueOf(o.getOrderId().toString()));
                        d.setReturnType((Integer) map.get("return_type"));
                        d.setAmount((BigDecimal) map.get("amount"));
                        d.setSpuCode((String)map.get("spu_code"));
                        d.setImageUrl((String) map.get("image_url"));
                        d.setReturnId((Integer) map.get("return_id"));
                        d.setSkuId((Integer) map.get("sku_id"));
                        d.setSalePrice((BigDecimal)map.get("sale_price"));
                        d.setIsDelete(((Boolean)map.get("is_delete")).toString());
                        d.setOrderDetailId(Long.valueOf(map.get("order_detail_id").toString()));
                        d.setPrice((BigDecimal)map.get("price"));
                        d.setQty((BigDecimal) map.get("qty"));
                        d.setBalanceAmount((BigDecimal)map.get("balance_amount"));
                        d.setReturnStatus((Integer)map.get("return_status"));
                        d.setSkuName((String)map.get("sku_name"));
                        d.setInventoryType((Integer) map.get("inventory_type"));
                        d.setSpuId((Integer) map.get("spu_id"));
                        d.setSkuCode((String)map.get("sku_code"));
                        d.setSkuDescription((String)map.get("sku_description"));
                        d.setReturnQty((Integer) map.get("return_qty"));
                        d.setSaleAmount((BigDecimal) map.get("sale_amount"));
                        weimobOrderDetailService.insert(d);
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

    }

    private void getMorePage(int pageCount,String create_begin_time,String create_end_time){
        if(pageCount > 1){
            for(int i=2;i<=pageCount;i++){
                Map<String,Object> param = new HashMap();
                param.put("page_no",i);
                param.put("page_size",pageSize);//最大支持50
                param.put("create_begin_time",create_begin_time);// yyyy-MM-dd HH:mm:ss
                param.put("create_end_time",create_end_time);// yyyy-MM-dd HH:mm:ss
                Map<String,Object> result = WeimobTokenRequester.getOrderDetailList(param);
                if(null!=result){
                    List<Map<String,Object>> items =  (List<Map<String,Object>>)result.get("page_data");
                    saveToDb(items);
                }
            }
        }
    }
}
