package com.qjf.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author QJF
 * @since 2018-03-16
 */
@TableName("t_weimob_order")
public class WeimobOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动类型: 普通=0,砍价=2,拼团=3,一元购=4,送礼=5
     */
    @TableField("activity_type")
    private Integer activityType;

    /**
     * 是否需要供货商发货(部分分销商的订单是由分销商自己发货的，这里用于区别)
     */
    @TableField("is_supplier_delivery")
    private String isSupplierDelivery;

    /**
     * 订单ID(自增长主键，不同店铺间有可能重复)
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 订单编号(订单编号，全局唯一)
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 订单来源(1、旺铺 2、不发货分销商 5、发货分销商 6、小程序，空值代表所有)
     */
    @TableField("order_source")
    private String orderSource;

    /**
     * 订单类型(全部 = 0,旺铺 = 1,分销 = 2,虚拟分销 = 4,旺铺小程序 = 8)
     */
    @TableField("order_type")
    private Integer orderType;

    /**
     * 订单状态(0所有，1交易中,2交易成功,3交易关闭)
     */
    @TableField("order_status")
    private Integer orderStatus;

    /**
     * 订单创建时间(时间格式为 yyyy-mm-dd hh24:mi:ss)
     */
    @TableField("create_time")
    private String createTime;

    /**
     * 创建人
     */
    @TableField("create_man")
    private String createMan;

    /**
     * 最近修改时间(时间格式为 yyyy-mm-dd hh24:mi:ss)
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 最近修改人
     */
    @TableField("update_man")
    private String updateMan;

    /**
     * 是否删除(订单被删除或关闭，该状态下终止一切操作)
     */
    @TableField("is_delete")
    private String isDelete;

    /**
     * 营销折扣金额
     */
    @TableField("discount_amount")
    private BigDecimal discountAmount;

    /**
     * 营销活动明细
     */
    @TableField("discount_detail")
    private String discountDetail;

    /**
     * 优惠券金额
     */
    @TableField("coupon_amount")
    private BigDecimal couponAmount;

    /**
     * 优惠券号码
     */
    @TableField("coupons_no")
    private String couponsNo;

    /**
     * 积分(所用积分数量)
     */
    @TableField("point_use")
    private Integer pointUse;

    /**
     * 积分金额(积分所抵扣的金额，假设10积分=1元，100积分抵扣10元)
     */
    @TableField("point_amount")
    private BigDecimal pointAmount;

    /**
     * 余额支付金额
     */
    @TableField("balance_amount")
    private BigDecimal balanceAmount;

    /**
     * 实际支付费用(实际支付费用=商品金额+运费-所有折扣类金额)
     */
    @TableField("real_amount")
    private BigDecimal realAmount;

    /**
     * 是否在线支付(在线支付和线下支付)
     */
    @TableField("is_onlinepay")
    private String isOnlinepay;

    /**
     * 订单支付状态(0待支付，1已支付)
     */
    @TableField("pay_status")
    private Integer payStatus;

    /**
     * 订单支付时间(未支付时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)
     */
    @TableField("pay_time")
    private String payTime;

    /**
     * payment_id
     */
    @TableField("payment_id")
    private String paymentId;

    /**
     * 支付方式编码
     */
    @TableField("payment_code")
    private String paymentCode;

    /**
     * 支付方式名称
     */
    @TableField("payment_name")
    private String paymentName;

    /**
     * 第三方支付单号(淘宝或微信的支付单号)
     */
    @TableField("payment_thirdno")
    private String paymentThirdno;

    /**
     * 运费(运费)
     */
    @TableField("delivery_amount")
    private BigDecimal deliveryAmount;

    /**
     * 物流状态(0待发货，1卖家发货，2买家收货，3部分发货)
     */
    @TableField("delivery_status")
    private Integer deliveryStatus;

    /**
     * 快递类型
     */
    @TableField("delivery_type")
    private String deliveryType;

    /**
     * 快递公司名称
     */
    @TableField("carrier_name")
    private String carrierName;

    /**
     * 快递单号(快递单号)
     */
    @TableField("express_no")
    private String expressNo;

    /**
     * 收件人地址(省市区之间以空格分隔)
     */
    @TableField("receiver_address")
    private String receiverAddress;

    /**
     * 收件人姓名(发货人姓名)
     */
    @TableField("receiver_name")
    private String receiverName;

    /**
     * 收件人联系电话(发货人联系电话)
     */
    @TableField("receiver_tel")
    private String receiverTel;

    /**
     * 发货人地址(省市区之间以空格分隔)
     */
    @TableField("sender_address")
    private String senderAddress;

    /**
     * 发货人姓名(发货人姓名)
     */
    @TableField("sender_name")
    private String senderName;

    /**
     * 发货人联系电话(发货人联系电话)
     */
    @TableField("sender_tel")
    private String senderTel;

    /**
     * 发货时间(未发货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)
     */
    @TableField("delivery_time")
    private String deliveryTime;

    /**
     * 确认收货时间(未确认收货时为空，时间格式为 yyyy-mm-dd hh24:mi:ss)
     */
    @TableField("receive_time")
    private String receiveTime;

    /**
     * 订单旗标(默认0，红色1，黄色2，绿色3，浅蓝4，深蓝5。传0进来会清除原有备注内容)
     */
    @TableField("order_flag")
    private Integer orderFlag;

    /**
     * 订单旗帜备注(这是旗帜备注)
     */
    @TableField("order_flag_memo")
    private String orderFlagMemo;

    /**
     * 订单备注(这是订单备注)
     */
    @TableField("remark")
    private String remark;

    /**
     * 商品总数量(SKU数量)
     */
    @TableField("sku_qty")
    private Integer skuQty;

    /**
     * 商品金额(商品总金额(不含运费))
     */
    @TableField("goods_amount")
    private BigDecimal goodsAmount;

    /**
     * 会员编号(会员编号)
     */
    @TableField("member_id")
    private String memberId;

    /**
     * 粉丝编号(用户在微信每公众号下的唯一标识)
     */
    @TableField("open_id")
    private String openId;

    /**
     * 用户自提信息JSON字符串(用户自提信息JSON字符串)
     */
    @TableField("user_ztInfo")
    private String userZtinfo;

    /**
     * 自提码,随机生成6位数字,跟订单关联,ZT系统可用于查询订单,核销订单
     */
    @TableField("zt_code")
    private String ztCode;

    /**
     * 扫二维码到订单核销自提
     */
    @TableField("zt_qrCode")
    private String ztQrcode;

    /**
     * 自提点Id,下单的时候就要确定到哪里提货
     */
    @TableField("zt_shopSetId")
    private Integer ztShopsetid;

    /**
     * 自提订单的核销状态,0未核销,1已核销
     */
    @TableField("hx_status")
    private String hxStatus;

    /**
     * 核销点,旺铺核销 或者自提点名称
     */
    @TableField("hx_by")
    private String hxBy;

    /**
     * 下单时选择商家配送时间类型: 0=工作日x双休日或节假日均可送货,1=只工作日送货,2=只双休日x节假日送货,
     */
    @TableField("distribution_timeType")
    private Integer distributionTimetype;

    /**
     * 商家配送时,用户选择的配送时间,用于展示
     */
    @TableField("mechant_deliveryTime")
    private String mechantDeliverytime;

    /**
     * 配送类型（商家配送 = 1,到店自提 = 2，同城限时达 = 4）
     */
    @TableField("distribution_type")
    private Integer distributionType;

    /**
     * 拼团状态（全部 = 0,开团中 = 1, 开团成功 = 2,开团失败 = 3,拼团成功 = 4,拼团失败 = 5, 拼团失败财务退款中 = 6
     */
    @TableField("pt_status")
    private Integer ptStatus;

    /**
     * 包裹行明细
     */
    @TableField("packs")
    private String packs;

    /**
     * 支付单号详情，当支付方式为众筹或订单类型为夺宝时，会出现多个支付单号
     */
    @TableField("payment_details")
    private String paymentDetails;

    /**
     * 粉丝信息(用户在微信的相关信息)
     */
    @TableField("fans_info")
    private String fansInfo;

    /**
     * distribution_info
     */
    @TableField("distribution_info")
    private String distributionInfo;

    /**
     * 收件人地址
     */
    @TableField("receiver_region")
    private String receiverRegion;

    /**
     * 订单行明细
     */
    @TableField("order_details")
    private String orderDetails;

    /**
     * 维权信息
     */
    @TableField("return_detail")
    private String returnDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
    public String getIsSupplierDelivery() {
        return isSupplierDelivery;
    }

    public void setIsSupplierDelivery(String isSupplierDelivery) {
        this.isSupplierDelivery = isSupplierDelivery;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }
    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }
    public String getCouponsNo() {
        return couponsNo;
    }

    public void setCouponsNo(String couponsNo) {
        this.couponsNo = couponsNo;
    }
    public Integer getPointUse() {
        return pointUse;
    }

    public void setPointUse(Integer pointUse) {
        this.pointUse = pointUse;
    }
    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }
    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }
    public String getIsOnlinepay() {
        return isOnlinepay;
    }

    public void setIsOnlinepay(String isOnlinepay) {
        this.isOnlinepay = isOnlinepay;
    }
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    public String getPaymentThirdno() {
        return paymentThirdno;
    }

    public void setPaymentThirdno(String paymentThirdno) {
        this.paymentThirdno = paymentThirdno;
    }
    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }
    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }
    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }
    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }
    public String getOrderFlagMemo() {
        return orderFlagMemo;
    }

    public void setOrderFlagMemo(String orderFlagMemo) {
        this.orderFlagMemo = orderFlagMemo;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(Integer skuQty) {
        this.skuQty = skuQty;
    }
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getUserZtinfo() {
        return userZtinfo;
    }

    public void setUserZtinfo(String userZtinfo) {
        this.userZtinfo = userZtinfo;
    }
    public String getZtCode() {
        return ztCode;
    }

    public void setZtCode(String ztCode) {
        this.ztCode = ztCode;
    }
    public String getZtQrcode() {
        return ztQrcode;
    }

    public void setZtQrcode(String ztQrcode) {
        this.ztQrcode = ztQrcode;
    }
    public Integer getZtShopsetid() {
        return ztShopsetid;
    }

    public void setZtShopsetid(Integer ztShopsetid) {
        this.ztShopsetid = ztShopsetid;
    }
    public String getHxStatus() {
        return hxStatus;
    }

    public void setHxStatus(String hxStatus) {
        this.hxStatus = hxStatus;
    }
    public String getHxBy() {
        return hxBy;
    }

    public void setHxBy(String hxBy) {
        this.hxBy = hxBy;
    }
    public Integer getDistributionTimetype() {
        return distributionTimetype;
    }

    public void setDistributionTimetype(Integer distributionTimetype) {
        this.distributionTimetype = distributionTimetype;
    }
    public String getMechantDeliverytime() {
        return mechantDeliverytime;
    }

    public void setMechantDeliverytime(String mechantDeliverytime) {
        this.mechantDeliverytime = mechantDeliverytime;
    }
    public Integer getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(Integer distributionType) {
        this.distributionType = distributionType;
    }
    public Integer getPtStatus() {
        return ptStatus;
    }

    public void setPtStatus(Integer ptStatus) {
        this.ptStatus = ptStatus;
    }
    public String getPacks() {
        return packs;
    }

    public void setPacks(String packs) {
        this.packs = packs;
    }
    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
    public String getFansInfo() {
        return fansInfo;
    }

    public void setFansInfo(String fansInfo) {
        this.fansInfo = fansInfo;
    }
    public String getDistributionInfo() {
        return distributionInfo;
    }

    public void setDistributionInfo(String distributionInfo) {
        this.distributionInfo = distributionInfo;
    }
    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }
    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "WeimobOrder{" +
        "id=" + id +
        ", activityType=" + activityType +
        ", isSupplierDelivery=" + isSupplierDelivery +
        ", orderId=" + orderId +
        ", orderNo=" + orderNo +
        ", orderSource=" + orderSource +
        ", orderType=" + orderType +
        ", orderStatus=" + orderStatus +
        ", createTime=" + createTime +
        ", createMan=" + createMan +
        ", updateTime=" + updateTime +
        ", updateMan=" + updateMan +
        ", isDelete=" + isDelete +
        ", discountAmount=" + discountAmount +
        ", discountDetail=" + discountDetail +
        ", couponAmount=" + couponAmount +
        ", couponsNo=" + couponsNo +
        ", pointUse=" + pointUse +
        ", pointAmount=" + pointAmount +
        ", balanceAmount=" + balanceAmount +
        ", realAmount=" + realAmount +
        ", isOnlinepay=" + isOnlinepay +
        ", payStatus=" + payStatus +
        ", payTime=" + payTime +
        ", paymentId=" + paymentId +
        ", paymentCode=" + paymentCode +
        ", paymentName=" + paymentName +
        ", paymentThirdno=" + paymentThirdno +
        ", deliveryAmount=" + deliveryAmount +
        ", deliveryStatus=" + deliveryStatus +
        ", deliveryType=" + deliveryType +
        ", carrierName=" + carrierName +
        ", expressNo=" + expressNo +
        ", receiverAddress=" + receiverAddress +
        ", receiverName=" + receiverName +
        ", receiverTel=" + receiverTel +
        ", senderAddress=" + senderAddress +
        ", senderName=" + senderName +
        ", senderTel=" + senderTel +
        ", deliveryTime=" + deliveryTime +
        ", receiveTime=" + receiveTime +
        ", orderFlag=" + orderFlag +
        ", orderFlagMemo=" + orderFlagMemo +
        ", remark=" + remark +
        ", skuQty=" + skuQty +
        ", goodsAmount=" + goodsAmount +
        ", memberId=" + memberId +
        ", openId=" + openId +
        ", userZtinfo=" + userZtinfo +
        ", ztCode=" + ztCode +
        ", ztQrcode=" + ztQrcode +
        ", ztShopsetid=" + ztShopsetid +
        ", hxStatus=" + hxStatus +
        ", hxBy=" + hxBy +
        ", distributionTimetype=" + distributionTimetype +
        ", mechantDeliverytime=" + mechantDeliverytime +
        ", distributionType=" + distributionType +
        ", ptStatus=" + ptStatus +
        ", packs=" + packs +
        ", paymentDetails=" + paymentDetails +
        ", fansInfo=" + fansInfo +
        ", distributionInfo=" + distributionInfo +
        ", receiverRegion=" + receiverRegion +
        ", orderDetails=" + orderDetails +
        "}";
    }

    public String getReturnDetail() {
        return returnDetail;
    }

    public void setReturnDetail(String returnDetail) {
        this.returnDetail = returnDetail;
    }
}
