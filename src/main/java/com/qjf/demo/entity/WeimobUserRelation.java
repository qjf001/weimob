package com.qjf.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2018-04-10
 */
@TableName("t_weimob_user_relation")
public class WeimobUserRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 昵称的openid
     */
    @TableField("nickname_openid")
    private String nicknameOpenid;

    /**
     * 关注来源的昵称
     */
    @TableField("source_nickname")
    private String sourceNickname;

    /**
     * 关注来源的openid
     */
    @TableField("source_openid")
    private String sourceOpenid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNicknameOpenid() {
        return nicknameOpenid;
    }

    public void setNicknameOpenid(String nicknameOpenid) {
        this.nicknameOpenid = nicknameOpenid;
    }
    public String getSourceNickname() {
        return sourceNickname;
    }

    public void setSourceNickname(String sourceNickname) {
        this.sourceNickname = sourceNickname;
    }
    public String getSourceOpenid() {
        return sourceOpenid;
    }

    public void setSourceOpenid(String sourceOpenid) {
        this.sourceOpenid = sourceOpenid;
    }

    @Override
    public String toString() {
        return "WeimobUserRelation{" +
        "id=" + id +
        ", nickname=" + nickname +
        ", nicknameOpenid=" + nicknameOpenid +
        ", sourceNickname=" + sourceNickname +
        ", sourceOpenid=" + sourceOpenid +
        "}";
    }
}
