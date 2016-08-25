package com.kp.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kp.domain.File;
import com.kp.service.FileService;
/**
 * 文件上传和下载
 * @author fiberhome
 * @date 2016年8月25日  上午9:44:38
 */
@Controller
public class FileController {
	private final Logger log=LoggerFactory.getLogger(FileController.class);
	
	@Resource
	private FileService fileService;
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public String addFile(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException{
		String kname=request.getParameter("kname");
		String ktype=request.getParameter("ktype");
		String extraInfo=request.getParameter("extraInfo");
		int userId=(int) request.getSession().getAttribute("userId");
        int status = 0;
		for(MultipartFile myfile : myfiles){
			if(myfile.isEmpty()){
				System.out.println("文件未上传");
			}
			else{
				String filepath=myfile.getOriginalFilename();
				File file=new File();
				file.setUserId(userId);
				file.setFileDes(extraInfo);
				file.setFileName(kname);
				file.setFileType(ktype);
				file.setFilePath(filepath);
				file.setFileStatus(status);
				
				String realPath=request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				//FileUtils.copyInputStreamToFile(myfile.getInputStream(), new java.io.File(realPath, myfile.getOriginalFilename()));
			}
		}
		return "gg";
	}
}
