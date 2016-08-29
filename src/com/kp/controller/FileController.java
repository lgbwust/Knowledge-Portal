package com.kp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kp.domain.File;
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
	
	@RequestMapping("/uploadFile")
	public String upload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
               // 这里我用到了jar包
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					String fileName = new SimpleDateFormat("yyyyMMddHHmmss")
							.format(new Date())+"_"+file.getOriginalFilename();

					String path1 = Thread.currentThread()
							.getContextClassLoader().getResource("").getPath()
							+ "download" + java.io.File.separator;
					String realPath = "D:/" + fileName;
					

					//  下面的加的日期是为了防止上传的名字一样
					String path = path1
							+ new SimpleDateFormat("yyyyMMddHHmmss")
									.format(new Date()) +"_"+ fileName;

					java.io.File localFile = new java.io.File(realPath);

					file.transferTo(localFile);
					
					//insert
					int userId=(int) request.getSession().getAttribute("userId");
					String extraInfo=(String) request.getParameter("extraInfo");
					
					File myfile=new File();
					myfile.setFileDes(extraInfo);
					myfile.setFileName(fileName);
					myfile.setFilePath(realPath);
					myfile.setFileStatus(0);
					myfile.setUserId(userId);
					
					fileService.insert(myfile);
				}

			}

		}
		return "admin/uploadResult";

	}

	@RequestMapping("/download")
	public String download(String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").getPath()
					+ "download";//这个download目录为啥建立在classes下的
			java.io.InputStream inputStream = new java.io.FileInputStream(new java.io.File(path
					+ java.io.File.separator + fileName));

			java.io.OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			 // 这里主要关闭。
			os.close();

			inputStream.close();
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
		return null;
	}

	/**
	 * 上传文件
	 * @param request
	 * @return
	 * @throws Exception
	 *
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
*/
}
