package com.qjf.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.MyPage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.qjf.common.BasicController;
import javax.annotation.Resource;

import com.qjf.common.ResultMap;
import com.qjf.demo.entity.AdminRole;
import com.qjf.demo.service.impl.AdminRoleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Controller
@RequestMapping("/admin/role")
public class AdminRoleController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(AdminRoleController.class);

    @Resource
    private AdminRoleServiceImpl adminRoleServiceImpl;

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 列表页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return COMMON_LIST;
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 列表页面数据
     */
    @ResponseBody
    @RequestMapping(value = "listData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public MyPage<AdminRole> listData(Page<AdminRole> page,HttpServletRequest req){
        EntityWrapper<AdminRole> wrapper = new EntityWrapper<>();
        return new MyPage(adminRoleServiceImpl.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(AdminRole record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;
            adminRoleServiceImpl.insertOrUpdate(record);
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
            model.addAttribute("data", adminRoleServiceImpl.selectById(id));
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
            adminRoleServiceImpl.deleteById(id);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
     }

    @RequestMapping("updateRoleResource")
    @ResponseBody
    public Map updateRoleResource(Integer roleId,Integer resourceId,String action){
        ResultMap rm = new ResultMap();
        try {
            adminRoleServiceImpl.updateRoleResource(roleId,resourceId,action);
            rm.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return rm;
    }
}
