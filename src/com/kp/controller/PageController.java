package com.kp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kp.domain.User;
import com.kp.service.UserService;

/**
 * 分页显示
 * @author fiberhome
 * @date 2016年8月26日  上午9:48:14
 */
public class PageController {
	private int userPageSize=5;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/listUser")
	public ModelAndView listUser(String page,Model model){
		//每页显示的条数
		int pageSize=userPageSize;
		
		List<User> users =new ArrayList<User>();
		users = this.userService.getAllUser();
		
		//查到的用户总数
		model.addAttribute("userNum",users.size());
		
		//总页数
		int pageTimes;
		if(users.size()%pageSize==0){
			pageTimes=users.size()/pageSize;
		}else{
			pageTimes=users.size()/pageSize+1;
		}
		model.addAttribute("pageTimes", pageTimes);
		
		//页面初始的时候page没有值
		if(null==page){
			page="1";
		}
		
		//每页开始的第几条记录
		int startRow = (Integer.parseInt(page)-1)*pageSize;
		users = this.userService.getUserByPage(startRow,pageSize);
		
		model.addAttribute("currentPage", Integer.parseInt(page));
		model.addAttribute("users", users);
		
		return new ModelAndView("user/test");
		
	}
}
