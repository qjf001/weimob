package com.qjf.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:Tin
 * @Date: create in 2017/12/13 16:16
 * @Description: 权限过滤器
 */
public class PermissionFilter extends AccessControlFilter {

    public static int SESSION_TIMEOUT_STATUS = 901;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String cp = req.getContextPath();
        int cpLength = cp.length();
        if(cpLength > 0)
            uri = uri.substring(cpLength,uri.length());
        //先判断带参数的权限判断
        Subject subject = getSubject(request, response);
        if(subject.isPermitted(uri))
            return  Boolean.TRUE;
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        HttpServletRequest req = (HttpServletRequest) request;

        if (null == subject.getPrincipal() || !subject.isAuthenticated()) {//表示没有登录，重定向到登录页面
            if ("XMLHttpRequest".equals(req.getHeader("x-requested-with")))
                WebUtils.toHttp(response).sendError(SESSION_TIMEOUT_STATUS);
            else
                saveRequestAndRedirectToLogin(request, response);
        }
        else {// 沒有權限
            if ("XMLHttpRequest".equals(req.getHeader("x-requested-with")))
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            else
                WebUtils.issueRedirect(request, response, "/401");
        }
        return Boolean.FALSE;
    }
}
