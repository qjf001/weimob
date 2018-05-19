package com.qjf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by geli on 2018/1/8.
 */
@Controller
@RequestMapping("admin")
public class PortalController {

    @RequestMapping(value = {"main",""})
    public String main(){
        return  "/layuiAdmin/main";
    }

    @RequestMapping(value = {"test"})
    public String test(){
        return  "/layuiAdmin/test";
    }

}
