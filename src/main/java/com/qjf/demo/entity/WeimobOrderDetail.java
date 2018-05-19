package com.qjf.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * t_weimob_order 的明细表
 * </p>
 *
 * @author QJF
 * @since 2018-05-19
 */
@TableName("t_weimob_order_detail")
public class WeimobOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("order_id")
    private Long orderId;

    @TableField("return_type")
    private Integer returnType;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("spu_code")
    private String spuCode;

    @TableField("image_url")
    private String imageUrl;

    @TableField("return_id")
    private Integer returnId;

    @TableField("sku_id")
    private Integer skuId;

    @TableField("sale_price")
    private BigDecimal salePrice;

    @TableField("is_delete")
    private String isDelete;

    @TableField("order_detail_id")
    private Long orderDetailId;

    @TableField("price")
    private BigDecimal price;

    @TableField("qty")
    private BigDecimal qty;

    @TableField("balance_amount")
    private BigDecimal balanceAmount;

    @TableField("return_status")
    private Integer returnStatus;

    @TableField("sku_name")
    private String skuName;

    @TableField("inventory_type")
    private Integer inventoryType;

    @TableField("spu_id")
    private Integer spuId;

    @TableField("sku_code")
    private String skuCode;

    @TableField("sku_description")
    private String skuDescription;

    @TableField("return_qty")
    private Integer returnQty;

    @TableField("sale_amount")
    private BigDecimal saleAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Integer getReturnType() {
        return returnType;
    }

    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }
    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    public Integer getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(Integer inventoryType) {
        this.inventoryType = inventoryType;
    }
    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }
    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    public String getSkuDescription() {
        return skuDescription;
    }

    public void setSkuDescription(String skuDescription) {
        this.skuDescription = skuDescription;
    }
    public Integer getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(Integer returnQty) {
        this.returnQty = returnQty;
    }
    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    @Override
    public String toString() {
        return "WeimobOrderDetail{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", returnType=" + returnType +
        ", amount=" + amount +
        ", spuCode=" + spuCode +
        ", imageUrl=" + imageUrl +
        ", returnId=" + returnId +
        ", skuId=" + skuId +
        ", salePrice=" + salePrice +
        ", isDelete=" + isDelete +
        ", orderDetailId=" + orderDetailId +
        ", price=" + price +
        ", qty=" + qty +
        ", balanceAmount=" + balanceAmount +
        ", returnStatus=" + returnStatus +
        ", skuName=" + skuName +
        ", inventoryType=" + inventoryType +
        ", spuId=" + spuId +
        ", skuCode=" + skuCode +
        ", skuDescription=" + skuDescription +
        ", returnQty=" + returnQty +
        ", saleAmount=" + saleAmount +
        "}";
    }
}
