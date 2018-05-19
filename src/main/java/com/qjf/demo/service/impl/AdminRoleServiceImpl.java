package com.qjf.demo.service.impl;

import com.qjf.demo.entity.AdminRole;
import com.qjf.demo.entity.AdminRoleResource;
import com.qjf.demo.mapper.AdminRoleMapper;
import com.qjf.demo.service.AdminRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

    @Resource
    private AdminRoleResourceServiceImpl adminRoleResourceServiceImpl;

    public void updateRoleResource(Integer roleId, Integer resourceId, String action) {

            if("add".equals(action)){
                AdminRoleResource rr = new AdminRoleResource();
                rr.setAdminRoleId(roleId);
                rr.setAdminResourceId(resourceId);
                adminRoleResourceServiceImpl.insert(rr);
            }else if("delete".equals(action)){
                AdminRoleResource rr = adminRoleResourceServiceImpl.findUniqueBy( roleId,  resourceId);
                if(null != rr)
                    adminRoleResourceServiceImpl.deleteById(rr.getId());
            }

    }
}
