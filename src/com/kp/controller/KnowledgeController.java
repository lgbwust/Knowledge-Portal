package com.kp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kp.service.KnowledgeService;
/**
 * 添加知识
 * @author fiberhome
 * @date 2016/8/23
 */
@Controller
public class KnowledgeController{
	@Resource
	private KnowledgeService knowledgeService;
	
	@RequestMapping(value="/addknowledge",method=RequestMethod.POST)
	public String addKnowledge(){
		return "user/addResult";		
	}
}

