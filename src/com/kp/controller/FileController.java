package com.kp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kp.service.FileService;
import com.kp.util.FileOperateUtil;
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

	/**
	 * 上传文件
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		// 别名
		String[] alaises = ServletRequestUtils.getStringParameters(request,
				"alais");

		String[] params = new String[] { "alais" };
		Map<String, Object[]> values = new HashMap<String, Object[]>();
		values.put("alais", alaises);

		List<Map<String, Object>> returnValue = FileOperateUtil.upload(request,
				params, values);

		List<String[]> result = new ArrayList<String[]>();
		for (Map<String, Object> item : returnValue) {
			String[] value = new String[2];
			Object obj1 = item.get("storeName");
			Object obj2 = item.get("realName");
			if (null != obj1 && null != obj2 && !obj1.toString().equals("")
					&& !obj2.toString().equals("")) {
				value[0] = obj1.toString();
				value[1] = obj2.toString();
				result.add(value);
			}
		}

		map.put("result", result);

		return new ModelAndView("background/fileOperate/list", map);
	}

	/**
	 * 下载
	 * @param attachment
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "download")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String storeName = ServletRequestUtils.getStringParameter(request,
				"storeName");
		String realName = ServletRequestUtils.getStringParameter(request,
				"realName");

		String contentType = "application/octet-stream";

		FileOperateUtil.download(request, response, storeName, contentType,
				realName);

		return null;
	}

}
