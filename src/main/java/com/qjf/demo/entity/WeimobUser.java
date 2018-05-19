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
 * 
 * </p>
 *
 * @author QJF
 * @since 2018-03-15
 */
@TableName("t_weimob_user")
public class WeimobUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信openid
     */
    @TableField("openid")
    private String openid;

    /**
     * 微盟openid
     */
    @TableField("weimob_openid")
    private String weimobOpenid;

    /**
     * 客户编号
     */
    @TableField("customer_no")
    private String customerNo;

    /**
     * 二维码地址
     */
    @TableField("qrcode_url")
    private String qrcodeUrl;

    /**
     * 条形码地址
     */
    @TableField("barcode_url")
    private String barcodeUrl;

    /**
     * 标签对象
     */
    @TableField("tags")
    private String tags;

    /**
     * 是否是粉丝
     */
    @TableField("is_fans")
    private String isFans;

    /**
     * 客户类型
     */
    @TableField("customer_type")
    private String customerType;

    /**
     * 类型名称
     */
    @TableField("levelname")
    private String levelname;

    /**
     * 会员卡号
     */
    @TableField("menbercard_id")
    private String menbercardId;

    /**
     * 成长值
     */
    @TableField("current_growth_value")
    private Integer currentGrowthValue;

    /**
     * 微信会员卡状态((0:未领卡 1:已领卡 2:已激活)
     */
    @TableField("wxcode_status")
    private Integer wxcodeStatus;

    /**
     * 微信Code
     */
    @TableField("wxcode")
    private String wxcode;

    /**
     * 成为会员时间
     */
    @TableField("register_date")
    private Long registerDate;

    /**
     * 会员卡有效期类型 会员卡有效期类型（1.永久有效 2.指定日期 3.固定天数）
     */
    @TableField("card_validity_type")
    private String cardValidityType;

    /**
     * 会员卡有效期
     */
    @TableField("card_validity_time")
    private Long cardValidityTime;

    /**
     * name
     */
    @TableField("name")
    private String name;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 头像图片地址
     */
    @TableField("portrait_url")
    private String portraitUrl;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * sex
     */
    @TableField("sex")
    private String sex;

    /**
     * 生日
     */
    @TableField("birth_day")
    private Long birthDay;

    /**
     * 累计积分
     */
    @TableField("total_points")
    private Integer totalPoints;

    /**
     * 当前积分
     */
    @TableField("current_points")
    private Integer currentPoints;

    /**
     * 当前余额
     */
    @TableField("current_amount")
    private BigDecimal currentAmount;

    /**
     * 累积交易金额
     */
    @TableField("total_transaction_amount")
    private BigDecimal totalTransactionAmount;

    /**
     * 交易次数
     */
    @TableField("total_transaction_count")
    private Integer totalTransactionCount;

    /**
     * 客单价
     */
    @TableField("average_amount")
    private BigDecimal averageAmount;

    /**
     * 上次交易时间
     */
    @TableField("last_transaction_time")
    private Long lastTransactionTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Long createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getWeimobOpenid() {
        return weimobOpenid;
    }

    public void setWeimobOpenid(String weimobOpenid) {
        this.weimobOpenid = weimobOpenid;
    }
    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }
    public String getBarcodeUrl() {
        return barcodeUrl;
    }

    public void setBarcodeUrl(String barcodeUrl) {
        this.barcodeUrl = barcodeUrl;
    }
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getIsFans() {
        return isFans;
    }

    public void setIsFans(String isFans) {
        this.isFans = isFans;
    }
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }
    public String getMenbercardId() {
        return menbercardId;
    }

    public void setMenbercardId(String menbercardId) {
        this.menbercardId = menbercardId;
    }
    public Integer getCurrentGrowthValue() {
        return currentGrowthValue;
    }

    public void setCurrentGrowthValue(Integer currentGrowthValue) {
        this.currentGrowthValue = currentGrowthValue;
    }
    public Integer getWxcodeStatus() {
        return wxcodeStatus;
    }

    public void setWxcodeStatus(Integer wxcodeStatus) {
        this.wxcodeStatus = wxcodeStatus;
    }
    public String getWxcode() {
        return wxcode;
    }

    public void setWxcode(String wxcode) {
        this.wxcode = wxcode;
    }
    public Long getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Long registerDate) {
        this.registerDate = registerDate;
    }
    public String getCardValidityType() {
        return cardValidityType;
    }

    public void setCardValidityType(String cardValidityType) {
        this.cardValidityType = cardValidityType;
    }
    public Long getCardValidityTime() {
        return cardValidityTime;
    }

    public void setCardValidityTime(Long cardValidityTime) {
        this.cardValidityTime = cardValidityTime;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Long birthDay) {
        this.birthDay = birthDay;
    }
    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
    public Integer getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(Integer currentPoints) {
        this.currentPoints = currentPoints;
    }
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
    public BigDecimal getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(BigDecimal totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }
    public Integer getTotalTransactionCount() {
        return totalTransactionCount;
    }

    public void setTotalTransactionCount(Integer totalTransactionCount) {
        this.totalTransactionCount = totalTransactionCount;
    }
    public BigDecimal getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(BigDecimal averageAmount) {
        this.averageAmount = averageAmount;
    }
    public Long getLastTransactionTime() {
        return lastTransactionTime;
    }

    public void setLastTransactionTime(Long lastTransactionTime) {
        this.lastTransactionTime = lastTransactionTime;
    }
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "WeimobUser{" +
        "id=" + id +
        ", openid=" + openid +
        ", weimobOpenid=" + weimobOpenid +
        ", customerNo=" + customerNo +
        ", qrcodeUrl=" + qrcodeUrl +
        ", barcodeUrl=" + barcodeUrl +
        ", tags=" + tags +
        ", isFans=" + isFans +
        ", customerType=" + customerType +
        ", levelname=" + levelname +
        ", menbercardId=" + menbercardId +
        ", currentGrowthValue=" + currentGrowthValue +
        ", wxcodeStatus=" + wxcodeStatus +
        ", wxcode=" + wxcode +
        ", registerDate=" + registerDate +
        ", cardValidityType=" + cardValidityType +
        ", cardValidityTime=" + cardValidityTime +
        ", name=" + name +
        ", nickname=" + nickname +
        ", portraitUrl=" + portraitUrl +
        ", phone=" + phone +
        ", sex=" + sex +
        ", birthDay=" + birthDay +
        ", totalPoints=" + totalPoints +
        ", currentPoints=" + currentPoints +
        ", currentAmount=" + currentAmount +
        ", totalTransactionAmount=" + totalTransactionAmount +
        ", totalTransactionCount=" + totalTransactionCount +
        ", averageAmount=" + averageAmount +
        ", lastTransactionTime=" + lastTransactionTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
