package com.qjf.demo.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qjf.common.BasicController;
import com.qjf.common.MyPage;
import com.qjf.common.ResultMap;
import com.qjf.demo.entity.WeimobUserRelation;
import com.qjf.demo.service.WeimobUserRelationService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author QJF
 * @since 2018-04-10
 */
@Controller
@RequestMapping("admin/weimobUserRelation")
public class WeimobUserRelationController extends BasicController
{
    private static final Logger logger = LoggerFactory.getLogger(WeimobUserRelationController.class);

    @Resource
    private WeimobUserRelationService weimobUserRelationService;

    /**
     * @Author:QJF
     * @Date: 2018-04-10
     * @Description: 列表页面
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return COMMON_LIST;
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-10
     * @Description: 列表页面数据
     */
    @ResponseBody
    @RequestMapping(value = "listData",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public MyPage<WeimobUserRelation> listData(Page<WeimobUserRelation> page,HttpServletRequest req){
        String nickname = req.getParameter("nickname");
        String sourceNickname =  req.getParameter("sourceNickname");
        EntityWrapper<WeimobUserRelation> wrapper = new EntityWrapper<>();
        if(!StringUtils.isBlank(nickname))
            wrapper.like("nickname",nickname);
        if(!StringUtils.isBlank(sourceNickname))
            wrapper.like("source_nickname",sourceNickname);
        return new MyPage(weimobUserRelationService.selectPage(page,wrapper));
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-10
     * @Description: 保存方法
     */
    @RequestMapping(value = "save",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map save(WeimobUserRelation record,BindingResult bindingResult) {
        ResultMap rm = new ResultMap();
        try {
            if(bindingResult.hasErrors())
                return rm;
            weimobUserRelationService.insertOrUpdate(record);
            rm.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return rm;
    }

    /**
     * @Author:QJF
     * @Date: 2018-04-10
     * @Description: 编辑页面
     */
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        if(null!=id)
            model.addAttribute("data", weimobUserRelationService.selectById(id));
        return COMMON_EDIT;
     }

    /**
     * @Author:QJF
     * @Date: 2018-04-10
     * @Description: 删除
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map delete(Long id) {
        ResultMap rm = new ResultMap();
        try {
            weimobUserRelationService.deleteById(id);
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
                    Sheet sheet = workbook.getSheetAt(0);
                    List<String[]> datas = new ArrayList<>();
                    for(int i=0;i<sheet.getLastRowNum()+1;i++){
                        Row r = sheet.getRow(i+1);
                        if(null==r)
                            continue;
                        String[] str = new String[2];
                        if(null != r.getCell(0) && null!=r.getCell(2)){
                            str[0] = r.getCell(0).getStringCellValue();
                            str[1] = r.getCell(2).getStringCellValue();
                            datas.add(str);
                        }
                    }

                    weimobUserRelationService.save( datas);

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
}
