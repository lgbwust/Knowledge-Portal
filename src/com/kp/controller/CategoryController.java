package com.kp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kp.service.CategoryService;
/**
 * 知识类别
 * @author fiberhome
 * ·date 2016/8/23
 */
@Controller
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping(value="/xx",method=RequestMethod.POST)
	public String xx(){
		return "xx";
	}
}
