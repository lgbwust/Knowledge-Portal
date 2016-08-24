package com.kp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kp.service.AdminService;

/**
 * 后台管理功能
 * @author fiberhome
 * @date 2016/8/24
 *
 */
@Controller
public class AdminController {
	//添加log信息
	private final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private AdminService adminService;

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminlogin(HttpServletRequest request) {
		//test output
		String name=request.getParameter("adminName");
		String psw=request.getParameter("adminPsw");
		System.out.println("管理员用户名为："+name);
		System.out.println("管理员密码为:"+psw);
		log.info(name);
		return "admin/index";
	}

}
