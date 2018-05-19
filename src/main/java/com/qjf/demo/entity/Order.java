package com.qjf.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
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
 * @since 2018-04-21
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId("id")
    private String id;

    /**
     * 结算时间
     */
    @TableField("payTime")
    private Date payTime;

    /**
     * 会员账号
     */
    @TableField("memberAccount")
    private String memberAccount;

    /**
     * 会员姓名
     */
    @TableField("memberName")
    private String memberName;

    /**
     * 订单金额
     */
    @TableField("orderAmount")
    private BigDecimal orderAmount;

    /**
     * 订单状态
     */
    @TableField("orderStatus")
    private String orderStatus;

    @TableField("leaveMessage")
    private String leaveMessage;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 邮编
     */
    @TableField("zipCode")
    private String zipCode;

    /**
     * 配送方式
     */
    @TableField("distribution")
    private String distribution;

    @TableField("distributionPrice")
    private BigDecimal distributionPrice;

    /**
     * 支付方式
     */
    @TableField("payWay")
    private String payWay;

    @TableField("orderMemo")
    private String orderMemo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }
    public BigDecimal getDistributionPrice() {
        return distributionPrice;
    }

    public void setDistributionPrice(BigDecimal distributionPrice) {
        this.distributionPrice = distributionPrice;
    }
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
    public String getOrderMemo() {
        return orderMemo;
    }

    public void setOrderMemo(String orderMemo) {
        this.orderMemo = orderMemo;
    }

    @Override
    public String toString() {
        return "Order{" +
        "id=" + id +
        ", payTime=" + payTime +
        ", memberAccount=" + memberAccount +
        ", memberName=" + memberName +
        ", orderAmount=" + orderAmount +
        ", orderStatus=" + orderStatus +
        ", leaveMessage=" + leaveMessage +
        ", name=" + name +
        ", address=" + address +
        ", mobile=" + mobile +
        ", zipCode=" + zipCode +
        ", distribution=" + distribution +
        ", distributionPrice=" + distributionPrice +
        ", payWay=" + payWay +
        ", orderMemo=" + orderMemo +
        "}";
    }
}
