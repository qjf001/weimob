package com.qjf.demo.filter;

import com.qjf.demo.controller.TopController;
import com.qjf.demo.entity.AdminResource;
import com.qjf.demo.service.impl.AdminResourceServiceImpl;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:Tin
 * @Date: create in 2017/12/12 14:33
 * @Description:
 *  資源過濾器--用於收集管理員後台資源路徑
 */
public class AdminResourceFilter extends OncePerRequestFilter {

    @Resource
    private AdminResourceServiceImpl adminResourceServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String uri = httpServletRequest.getRequestURI();
        List<String> uris = TopController.adminUris;
        // 过滤非法的资源被接受，原本可以直接将所有的后台资源保存到数据库
        if(!TopController.adminUris.contains(uri) || uri.equals("/admin/main")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return ;
        }
        AdminResource resource = adminResourceServiceImpl.findUniqueByUri(uri);
        if(null==resource){
            resource = new AdminResource();
            setResourceName( uri, resource);
            resource.setUrl(uri);
            adminResourceServiceImpl.insert(resource);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void setResourceName(String uri,AdminResource resource){
        String name;
        if(uri.contains("/user/"))
            name="用戶";
        else if(uri.contains("/adminUser/"))
            name="系統用戶";
        else if(uri.contains("/role/"))
            name="角色";
        else if(uri.contains("/resource/"))
            name="資源";
        else
            name="其它";

        name += "_";

        if(uri.endsWith("list") || uri.endsWith("rateRecordList"))
            name += "列表頁面";
        else if(uri.endsWith("edit"))
            name += "新增/編輯頁面";
        else if(uri.endsWith("save"))
            name += "保存/更新";
        else if(uri.endsWith("freezeOrNot"))
            name += "凍結/解凍";
        else if(uri.endsWith("resetPwd"))
            name += "重置密碼";
        else if(uri.endsWith("delete"))
            name += "刪除";
        else if(uri.endsWith("listData") || uri.endsWith("DataList") || uri.endsWith("adminOrderList") || uri.endsWith("adminOrderRefundList") || uri.endsWith("findChildrenByParentSn") || uri.endsWith("userList"))
            name += "列表數據";
        else
            name += "其它";
        resource.setName(name);
    }
}
