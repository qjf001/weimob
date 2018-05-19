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
import com.qjf.demo.entity.OrderDetail;
import com.qjf.demo.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author QJF
 * @since 2018-04-21
 */
@Controller
@RequestMapping("admin/orderDetail")
public class OrderDetailController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(OrderDetailController.class);

    @Resource
    private OrderDetailService orderDetailService;

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 列表页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return COMMON_LIST;
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 列表页面数据
     */
    @ResponseBody
    @RequestMapping(value = "listData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public MyPage<OrderDetail> listData(Page<OrderDetail> page,HttpServletRequest req){
        EntityWrapper<OrderDetail> wrapper = new EntityWrapper<>();
        return new MyPage(orderDetailService.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(OrderDetail record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;
            orderDetailService.insertOrUpdate(record);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 编辑页面
     */
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        if(null!=id)
            model.addAttribute("data", orderDetailService.selectById(id));
        return COMMON_EDIT;
     }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map delete(Integer id) {
        ResultMap rm = new ResultMap();
        try {
            orderDetailService.deleteById(id);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
     }
}
