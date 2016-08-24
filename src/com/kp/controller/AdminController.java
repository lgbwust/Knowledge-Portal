package com.kp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.kp.service.AdminService;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
	
}
