package com.qjf.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.MyPage;
import com.qjf.demo.entity.AdminRoleResource;
import com.qjf.demo.service.impl.AdminRoleResourceServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.qjf.common.BasicController;
import javax.annotation.Resource;

import com.qjf.common.ResultMap;
import com.qjf.demo.entity.AdminResource;
import com.qjf.demo.service.impl.AdminResourceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 资源表（也叫权限） 前端控制器
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Controller
@RequestMapping("/admin/resource")
public class AdminResourceController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(AdminResourceController.class);

    @Resource
    private AdminResourceServiceImpl adminResourceServiceImpl;

    @Resource
    private AdminRoleResourceServiceImpl adminRoleResourceServiceImpl;

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 列表页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return COMMON_LIST;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.GET)
    public String selectList(Model model,Integer id){
        model.addAttribute("roleId",id);
        return COMMON_SELECT;
    }

    @ResponseBody
    @RequestMapping(value = "selectListData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public MyPage<AdminResource> selectListData(Page<AdminResource> page,HttpServletRequest req){
        EntityWrapper<AdminResource> wrapper = new EntityWrapper<>(new AdminResource());
        return new MyPage(adminResourceServiceImpl.selectPage(page,wrapper));
    }

    @RequestMapping(value = "getRoleResourceId",method = RequestMethod.GET)
    @ResponseBody
    public Map getRoleResourceId(Integer id){
        ResultMap rm = new ResultMap(true);
        // 查詢這個角色所有的資源主鍵
        List<AdminRoleResource> rrs = adminRoleResourceServiceImpl.findRoleResourceByRoleId(id);
        String resourceIds = rrs.stream().map(rr->rr.getAdminResourceId().toString()).collect(Collectors.joining(","));
        rm.put("roleResourceIds",resourceIds);
        return rm;
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 列表页面数据
     */
    @ResponseBody
    @RequestMapping(value = "listData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public MyPage<AdminResource> listData(Page<AdminResource> page,HttpServletRequest req){
        EntityWrapper<AdminResource> wrapper = new EntityWrapper<>(new AdminResource());
        return new MyPage(adminResourceServiceImpl.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(AdminResource record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;
            adminResourceServiceImpl.insertOrUpdate(record);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 编辑页面
     */
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        if(null!=id)
            model.addAttribute("data", adminResourceServiceImpl.selectById(id));
        return COMMON_EDIT;
     }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map delete(Integer id) {
        ResultMap rm = new ResultMap();
        try {
            adminResourceServiceImpl.deleteById(id);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
     }
}
