package com.qjf.demo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色资源对应表
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@TableName("t_admin_role_resource")
public class AdminRoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("admin_role_id")
    private Integer adminRoleId;
    @TableField("admin_resource_id")
    private Integer adminResourceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Integer adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public Integer getAdminResourceId() {
        return adminResourceId;
    }

    public void setAdminResourceId(Integer adminResourceId) {
        this.adminResourceId = adminResourceId;
    }

    @Override
    public String toString() {
        return "AdminRoleResource{" +
        "id=" + id +
        ", adminRoleId=" + adminRoleId +
        ", adminResourceId=" + adminResourceId +
        "}";
    }
}
