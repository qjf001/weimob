package com.qjf.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.MyPage;
import com.qjf.demo.service.OrderDetailService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.qjf.common.BasicController;
import javax.annotation.Resource;

import com.qjf.common.ResultMap;
import com.qjf.demo.entity.Order;
import com.qjf.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("admin/order")
public class OrderController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Resource
    private OrderService orderService;

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
    public MyPage<Order> listData(Page<Order> page,HttpServletRequest req){
        EntityWrapper<Order> wrapper = new EntityWrapper<>();
        return new MyPage(orderService.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(Order record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;
            orderService.insertOrUpdate(record);
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
    public String edit(Model model, String id) {
        if(null!=id)
            model.addAttribute("data", orderService.selectById(id));
        return COMMON_EDIT;
     }

    /**
     * @Author:QJF
     * @Date: 2018-04-21
     * @Description: 删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map delete(String id) {
        ResultMap rm = new ResultMap();
        try {
            orderService.deleteById(id);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
     }

    @RequestMapping(value = "upload",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map upload(@RequestParam MultipartFile file) {
        ResultMap rm = new ResultMap();
        try {
            String originalFilename = file.getOriginalFilename();
            if(originalFilename.endsWith(".xls")){
                // 解析 excel 文件
                try (InputStream in = file.getInputStream()){
                    HSSFWorkbook workbook = new HSSFWorkbook(in);
                    saveOrder(workbook);
                    saveOrderDetail(workbook);
                    return rm.setSuccess();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else{
                rm.setFail("文件不能被正确解析");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
    }

    private void saveOrder(HSSFWorkbook workbook){
        Sheet sheet = workbook.getSheetAt(0);
        List<String[]> datas = new ArrayList<>();
        for(int i=0;i<sheet.getLastRowNum()+1;i++){
            Row r = sheet.getRow(i+1);
            if(null==r)
                continue;
            String[] str = new String[15];
            if(null != r.getCell(0)){
                str[0] = r.getCell(0).getStringCellValue();
                str[1] = sdf.format(r.getCell(1).getDateCellValue());
                str[2] = r.getCell(2).getStringCellValue();
                str[3] = r.getCell(3).getStringCellValue();
                str[4] = r.getCell(4).getStringCellValue();
                str[5] = r.getCell(5).getStringCellValue();
                str[6] = r.getCell(6).getStringCellValue();
                str[7] = r.getCell(7).getStringCellValue();
                str[8] = r.getCell(8).getStringCellValue();
                str[9] = r.getCell(9).getStringCellValue();
                str[10] = r.getCell(10).getStringCellValue();
                str[11] = r.getCell(11).getStringCellValue();
                str[12] = String.valueOf(r.getCell(12).getNumericCellValue());
                str[13] = r.getCell(13).getStringCellValue();
                str[14] = r.getCell(14).getStringCellValue();
                datas.add(str);
            }
        }
        orderService.save( datas);
    }

    private void saveOrderDetail(HSSFWorkbook workbook){
        Sheet sheet = workbook.getSheetAt(1);
        List<String[]> datas = new ArrayList<>();
        for(int i=0;i<sheet.getLastRowNum()+1;i++){
            Row r = sheet.getRow(i+1);
            if(null==r)
                continue;
            String[] str = new String[17];
            if(null != r.getCell(0)){
                str[0] = r.getCell(0).getStringCellValue();
                str[1] = r.getCell(1).getStringCellValue();
                str[2] = r.getCell(2).getStringCellValue();
                str[3] = r.getCell(3).getStringCellValue();
                str[4] = String.valueOf(r.getCell(4).getNumericCellValue());
                str[5] = String.valueOf(r.getCell(5).getNumericCellValue());
                str[6] = String.valueOf(r.getCell(6).getNumericCellValue());
                str[7] = r.getCell(7).getStringCellValue();
                str[8] = r.getCell(8).getStringCellValue();
                str[9] = r.getCell(9).getStringCellValue();
                str[10] = r.getCell(10).getStringCellValue();
                str[11] = r.getCell(11).getStringCellValue();
                str[12] = r.getCell(12).getStringCellValue();
                str[13] = r.getCell(13).getStringCellValue();
                str[14] = String.valueOf(r.getCell(14).getNumericCellValue());
                str[15] = r.getCell(15).getStringCellValue();
                str[16] = r.getCell(16).getStringCellValue();
                datas.add(str);
            }
        }
        orderDetailService.save(datas);
    }
}
