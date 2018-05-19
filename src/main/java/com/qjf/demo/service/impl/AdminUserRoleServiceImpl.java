package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.qjf.demo.entity.AdminUserRole;
import com.qjf.demo.mapper.AdminUserRoleMapper;
import com.qjf.demo.service.AdminUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色对应表 服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Service
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements AdminUserRoleService {

    public AdminUserRole findUserRoleByUserId(Integer userId){
        EntityWrapper<AdminUserRole> wrapper = new EntityWrapper<>();
        wrapper.eq("admin_user_id",userId);
       return selectOne(wrapper);
    }

}
