package com.qjf.demo.controller;

import com.qjf.common.BasicController;
import com.qjf.common.Md5Util;
import com.qjf.common.ResultMap;
import com.qjf.demo.entity.AdminRole;
import com.qjf.demo.entity.AdminUser;
import com.qjf.demo.entity.AdminUserRole;
import com.qjf.demo.service.impl.AdminResourceServiceImpl;
import com.qjf.demo.service.impl.AdminRoleServiceImpl;
import com.qjf.demo.service.impl.AdminUserRoleServiceImpl;
import com.qjf.demo.service.impl.AdminUserServiceImpl;
import com.qjf.shiro.VerificationCodeException;
import com.qjf.shiro.filter.MyFormAuthenticationFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by boowa on 2017/4/10
 */
@Controller
@RequestMapping("/")
public class TopController extends BasicController {

    private static Logger logger = LoggerFactory.getLogger(TopController.class);

    @Resource
    private AdminUserServiceImpl adminUserServiceImpl;

    @Resource
    private AdminRoleServiceImpl adminRoleServiceImpl;

    @Resource
    private AdminUserRoleServiceImpl adminUserRoleServiceImpl;

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Resource
    AdminResourceServiceImpl adminResourceServiceImpl;

    public static List<String> adminUris = new ArrayList<>();

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login() {
        getAllAdminUri();
        return "/admin/login";
    }

    /**
     * @Author:QJF
     * @Date: 2018/1/9 11:14
     * @Description: 获取所有的后台资源
     */
    private void getAllAdminUri(){
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        Set<RequestMappingInfo> rmi = map.keySet();
        final List<String> uris = new ArrayList<>();
        rmi.forEach(a-> uris.addAll(a.getPatternsCondition().getPatterns()));
        Set<String> aUris = uris.stream().filter(str->str.startsWith("/admin/")).collect(Collectors.toSet());

        for(String uri : aUris){
            if(!adminUris.contains(uri)){
                adminUris.add(uri);
            }
        }
        Collections.sort(adminUris);
    }

    /**
     * 禁止执行访问
     */
    @RequestMapping(value = {"/403"})
    public String _403() {
        return "/admin/403";
    }

    /**
     * 未授权
     **/
    @RequestMapping(value = {"/401"})
    public String noPermission() {
        return "/admin/401";
    }

    /**
     * 使用 shiro formAuthenticationFilter 做登錄,只有登录出现异常才会进入登录的controller方法,
     * 因此可以在登录的过滤器中设置HttpSession
     * 使用 shiro formAuthenticationFilter 做登錄，使用表單post提交，不要使用ajax提交，
     * 因為ajax的提交登錄成功后的跳轉，在瀏覽器不能正確執行（通過瀏覽器的監視可以觀察到正確的重定向及返回內容，但是也沒刷新出欄）
     **/
//    @ResponseBody
    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public String toLogin(Model model, HttpServletRequest req) {
        String exceptionClassName = (String) req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (!StringUtils.isBlank(exceptionClassName)) {
            if (AccountException.class.getName().equals(exceptionClassName) || VerificationCodeException.class.getName().equals(exceptionClassName))
                model.addAttribute("message", req.getAttribute(MyFormAuthenticationFilter.DEFAULT_ERRORMSG_KEY_ATTRIBUTE));
            else
                model.addAttribute("message", "登錄異常！");
        }
        return "/admin/login";
    }

    @ResponseBody
    @RequestMapping("admin/logout")
    public Map logout() {
        ResultMap rm = new ResultMap(true);
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            return rm.setFail();
        }
        return rm;
    }

    @ResponseBody
    @RequestMapping("admin/resetPwd")
    public Map resetPwd(HttpSession httpSession, String password) {
        ResultMap rm = new ResultMap(true);
        try {
            AdminUser au = (AdminUser)httpSession.getAttribute("user");
            AdminUser user = adminUserServiceImpl.selectById(au.getId());
            if (null != user && !StringUtils.isBlank(password)) {
                user.setPassword(Md5Util.MD5LowerCase(password,2));
                adminUserServiceImpl.updateById(user);
            }
        } catch (Exception e) {
            return rm.setFail();
        }
        return rm;
    }

    @RequestMapping(value = {"/admin/main"}, method = RequestMethod.GET)
    public String main(HttpSession session) {

        AdminUser auser = (AdminUser) session.getAttribute("user");
        AdminRole role = (AdminRole) session.getAttribute("role");
        if(null == role && null != auser){
            AdminUserRole ur = adminUserRoleServiceImpl.findUserRoleByUserId(auser.getId());
            if(null != ur ){
                role = adminRoleServiceImpl.selectById(ur.getAdminRoleId());
                session.setAttribute("role",role);
            }
        }
        return "/admin/layuiAdmin/main";
    }

}
