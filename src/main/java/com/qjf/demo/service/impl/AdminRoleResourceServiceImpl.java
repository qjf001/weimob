package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qjf.demo.entity.AdminRoleResource;
import com.qjf.demo.mapper.AdminRoleResourceMapper;
import com.qjf.demo.service.AdminRoleResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色资源对应表 服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Service
public class AdminRoleResourceServiceImpl extends ServiceImpl<AdminRoleResourceMapper, AdminRoleResource> implements AdminRoleResourceService {

    public List<AdminRoleResource> findRoleResourceByRoleId(Integer roleId) {
        EntityWrapper<AdminRoleResource> wp = new EntityWrapper<>();
        wp.eq("admin_role_id",roleId);
        return selectList(wp);
    }

    public AdminRoleResource findUniqueBy(Integer roleId, Integer resourceId) {
        EntityWrapper<AdminRoleResource> wp = new EntityWrapper<>();
        wp.eq("admin_role_id",roleId);
        wp.eq("admin_resource_id",resourceId);
        return selectOne(wp);
    }
}
