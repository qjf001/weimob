
package com.qjf.shiro;

import com.qjf.demo.entity.*;
import com.qjf.demo.service.impl.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:Tin
 * @Date: create in 2017/12/11 10:39
 * @Description: 与数据库交互并保存权限数据
 */

public class CmsShiroRealm extends AuthorizingRealm {

    @Resource
    private AdminResourceServiceImpl adminResourceServiceImpl;

    @Resource
    private AdminRoleServiceImpl adminRoleServiceImpl;

    @Resource
    private AdminUserRoleServiceImpl adminUserRoleServiceImpl;

    @Resource
    private AdminRoleResourceServiceImpl adminRoleResourceServiceImpl;

    @Resource
    private AdminUserServiceImpl adminUserServiceImpl;

    /**
     * 认证信息，主要针对用户登录，
     */

    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordCodeToken token = (UsernamePasswordCodeToken) authcToken;

        AdminUser user = adminUserServiceImpl.findBy(token.getUsername(), new String(token.getPassword()));
//        AdminUser user = adminUserServiceImpl.findBy(token.getUsername(), new String(token.getPassword()));
        if (null == user) {
            throw new AccountException("賬號或者密碼不正確");
        } /*else if (user.getStatus().intValue() != 1) {
            throw new AccountException("您已被限制登錄");
        }*/
//        return new SimpleAuthenticationInfo(user, Object hashedCredentials, ByteSource credentialsSalt, String realmName);
        return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
    }


    /**
     * 授权
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AdminUser token = (AdminUser) SecurityUtils.getSubject().getPrincipal();
        Integer userId = token.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        AdminUserRole ur = adminUserRoleServiceImpl.findUserRoleByUserId(userId);
        if (null == ur)
            return info;
        AdminRole role = adminRoleServiceImpl.selectById(ur.getAdminRoleId());
        Set<String> roles = new HashSet<>();
        roles.add(role.getName());
        info.setRoles(roles);
        //根据用户ID查询权限（permission），放入到Authorization里。
        List<AdminRoleResource> rrs = adminRoleResourceServiceImpl.findRoleResourceByRoleId(role.getId());
        Set<String> resources = new HashSet<>();
        rrs.forEach(rr -> {
            AdminResource resource = adminResourceServiceImpl.selectById(rr.getAdminResourceId());
            if (null != resource) {
                resources.add(resource.getUrl());
            }
        });

        info.setStringPermissions(resources);
        return info;
    }


    /**
     * 清空当前用户权限信息
     */

    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }


    /**
     * 指定principalCollection 清除
     */

    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

}

