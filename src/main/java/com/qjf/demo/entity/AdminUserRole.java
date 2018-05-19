package com.qjf.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户角色对应表
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@TableName("t_admin_user_role")
public class AdminUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 后台用户主键
     */
    @TableField("admin_user_id")
    private Integer adminUserId;
    /**
     * 后台角色主键
     */
    @TableField("admin_role_id")
    private Integer adminRoleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    @Override
    public String toString() {
        return "AdminUserRole{" +
        "id=" + id +
        ", adminUserId=" + adminUserId +
        ", adminRoleId=" + adminRoleId +
        "}";
    }
}
