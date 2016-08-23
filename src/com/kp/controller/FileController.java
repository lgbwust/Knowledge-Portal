package com.kp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kp.service.FileService;
/**
 * 文件上传处理
 * @author fiberhome
 * @date 2016/8/23
 */
@Controller
public class FileController {
	@Resource
	private FileService fileService;
	@RequestMapping(value="/ff")
	public String addFile(){
		return "gg";
	}
}
