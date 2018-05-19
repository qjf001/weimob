package com.qjf.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author QJF
 * @since 2018-04-21
 */
@TableName("t_order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    @TableField("orderSn")
    private String orderSn;

    /**
     * 产品名称
     */
    @TableField("productName")
    private String productName;

    @TableField("productCate")
    private String productCate;

    /**
     * 购物选项
     */
    @TableField("shoppingOption")
    private String shoppingOption;

    /**
     * 单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField("num")
    private Integer num;

    @TableField("subtotal")
    private BigDecimal subtotal;

    /**
     * 会员账号
     */
    @TableField("memberAccount")
    private String memberAccount;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductCate() {
        return productCate;
    }

    public void setProductCate(String productCate) {
        this.productCate = productCate;
    }
    public String getShoppingOption() {
        return shoppingOption;
    }

    public void setShoppingOption(String shoppingOption) {
        this.shoppingOption = shoppingOption;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
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
        return "OrderDetail{" +
        "id=" + id +
        ", orderSn=" + orderSn +
        ", productName=" + productName +
        ", productCate=" + productCate +
        ", shoppingOption=" + shoppingOption +
        ", price=" + price +
        ", num=" + num +
        ", subtotal=" + subtotal +
        ", memberAccount=" + memberAccount +
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
