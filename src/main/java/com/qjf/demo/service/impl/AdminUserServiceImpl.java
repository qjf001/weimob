package com.qjf.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qjf.demo.entity.AdminUser;
import com.qjf.demo.entity.AdminUserRole;
import com.qjf.demo.mapper.AdminUserMapper;
import com.qjf.demo.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Resource
    private AdminUserRoleServiceImpl adminUserRoleServiceImpl;

    /**
     * @Author:QJF
     * @Date: 2018/1/25 17:04
     * @Description:
     * 对于角色的操作：新增、删除、修改
     */
    public boolean update(AdminUser user,Integer roleId) {
       updateById(user);
        AdminUserRole ur = adminUserRoleServiceImpl.findUserRoleByUserId(user.getId());
        if(null == ur && null != roleId){ // 给没有角色的用户指定角色
            ur = new AdminUserRole();
            ur.setAdminUserId(user.getId());
            ur.setAdminRoleId(roleId);
            adminUserRoleServiceImpl.insert(ur);
        }
        else{
            if(null == roleId){ // 将用户的角色删除掉
                adminUserRoleServiceImpl.deleteById(ur.getId());
            }else if(ur.getAdminRoleId().intValue() != roleId.intValue()){// 用户角色有变化
                ur.setAdminRoleId(roleId);
                adminUserRoleServiceImpl.updateById(ur);
            }
        }
        return true;
    }

    public boolean save(AdminUser record,Integer roleId) {
        insert(record);
        if(null != roleId)
        {
            AdminUserRole ur = new AdminUserRole();
            ur.setAdminUserId(record.getId());
            ur.setAdminRoleId(roleId);
            adminUserRoleServiceImpl.insert(ur);
        }
        return true;
    }

    public void delete(Integer id) {
        deleteById(id);
        // 需要刪除用戶角色對應信息 userRole
        AdminUserRole ur = adminUserRoleServiceImpl.findUserRoleByUserId(id);
        if(null != ur)
            adminUserRoleServiceImpl.deleteById(ur.getId());
    }

    public AdminUser findByName(String userName){
        EntityWrapper<AdminUser> wp = new EntityWrapper<>();
        wp.eq("name",userName);
        return selectOne(wp);
    }

    public AdminUser findBy(String userName, String pwd) {
        EntityWrapper<AdminUser> wp = new EntityWrapper<>();
        wp.eq("name",userName);
        wp.eq("password",pwd);
        return selectOne(wp);
    }
}
