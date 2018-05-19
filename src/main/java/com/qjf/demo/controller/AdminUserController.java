package com.qjf.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.MyPage;
import com.qjf.common.SearchOptionForPageUtil;
import com.qjf.demo.entity.AdminRole;
import com.qjf.demo.entity.AdminUserRole;
import com.qjf.demo.service.impl.AdminRoleServiceImpl;
import com.qjf.demo.service.impl.AdminUserRoleServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.qjf.common.BasicController;
import javax.annotation.Resource;

import com.qjf.common.ResultMap;
import com.qjf.demo.entity.AdminUser;
import com.qjf.demo.service.impl.AdminUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户 前端控制器
 * </p>
 *
 * @author QJF
 * @since 2018-03-10
 */
@Controller
@RequestMapping("/admin/adminUser")
public class AdminUserController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Resource
    private AdminUserServiceImpl adminUserServiceImpl;

    @Resource
    private AdminRoleServiceImpl adminRoleServiceImpl;

    @Resource
    private AdminUserRoleServiceImpl adminUserRoleServiceImpl;

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
    public MyPage<AdminUser> listData(Page<AdminUser> page,HttpServletRequest req){
        EntityWrapper<AdminUser> wrapper = new EntityWrapper<>();
        return new MyPage(adminUserServiceImpl.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-03-10
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(Integer roleId,AdminUser record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;

            try {
                boolean flag = (null != record.getId()) ? adminUserServiceImpl.update(record, roleId) : adminUserServiceImpl.save(record, roleId);
                rm.setSuccess();
            } catch (Exception e) {
                logger.error(e.getMessage());
                if(e.getMessage().contains("Exception: Duplicate entry"))
                    rm.setMsg("登錄賬號已佔用，請重新輸入登錄賬號");
            }

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
            model.addAttribute("data", adminUserServiceImpl.selectById(id));

        List<AdminRole> roles = adminRoleServiceImpl.selectList(new EntityWrapper<>());

        final List<Map<String, Object>> list = roles.stream().map(r -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", r.getId().toString());
            map.put("name", r.getNickName());
            return map;
        }).collect(Collectors.toList());

        model.addAttribute("roles", SearchOptionForPageUtil.rebuild(list, "id", "name"));
        // 查詢用戶角色
        if(null!=id){
            AdminUserRole ur = adminUserRoleServiceImpl.findUserRoleByUserId(id);
            model.addAttribute("ur", ur);
        }
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
            adminUserServiceImpl.deleteById(id);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
     }
}
