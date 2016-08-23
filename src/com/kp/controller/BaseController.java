package com.kp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理页面间的各种jsp跳转问题
 * @author fiberhome
 * @date 2016/8/23
 */
@Controller
public class BaseController {
    @Resource

    //处理主页请求
    @RequestMapping(value = "/mainPage")
    public String mainPage(HttpServletRequest request){
        return  "main";
    }
    
    //主页入口请求
    @RequestMapping(value = "/btn1")
    public String S1_Page(HttpServletRequest request){
        return  "/user/login";
    }
    @RequestMapping(value = "/btn2")
    public String S2_Page(HttpServletRequest request){
        return  "user/register";
    }
    @RequestMapping(value = "/btn3")
    public String S3_Page(HttpServletRequest request){
        return  "admin/index";
    }
    
    //登录后菜单请求
    @RequestMapping(value = "/add")
    public String S4_Page(HttpServletRequest request){
        return  "user/addknowledge";
    }
    @RequestMapping(value = "/sea")
    public String S5_Page(HttpServletRequest request){
        return  "user/search";
    }
    @RequestMapping(value = "/upl")
    public String S6_Page(HttpServletRequest request){
        return  "user/upload";
    }
    @RequestMapping(value = "/ind")
    public String S7_Page(HttpServletRequest request){
        return  "user/index";
    }
}
