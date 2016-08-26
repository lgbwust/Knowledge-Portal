package com.kp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kp.domain.Admin;
import com.kp.domain.KnowledgeWithBLOBs;
import com.kp.domain.User;
import com.kp.service.AdminService;
import com.kp.service.FileService;
import com.kp.service.KnowledgeService;
import com.kp.service.UserService;
import com.kp.util.JsonUtil;


/**
 * 后台管理功能
 * @author fiberhome
 * @date 2016/8/24
 *
 */
@Controller
public class AdminController extends JsonUtil {
	//添加log信息
	private final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private AdminService adminService;
	@Resource
	private UserService userService;
	@Resource
	private FileService fileService;
	@Resource
	private KnowledgeService knowledgeService;

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminlogin(HttpServletRequest request) {
		//test output
		String name=request.getParameter("adminName");
		String psw=request.getParameter("adminPsw");
		System.out.println("管理员用户名为："+name);
		System.out.println("管理员密码为:"+psw);
		log.info(name);
		Admin admin=adminService.selectByName(name);
		if(admin!=null&&admin.getAdminPsw().equals(psw)){
			//将管理员名字保存到session中以便前台获取
			request.getSession().setAttribute("adname", name);
			return "admin/test";
		}
		else{
			request.getSession().setAttribute("admsg", "登录失败,用户名或密码错误~~~ :)");
			return "admin/adminlogin";
			}
		//return "admin/adminlogin";
	}
	
	/**
	 * 用户管理
	 * @param page
	 * @param rows
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="/userList")
	public  void userList(int page,int rows,HttpServletResponse response,Model model) throws IOException{  
        response.setContentType("application/json; charset=utf-8");  
        //求得开始记录与结束记录  
        int start = (page-1)*rows;  
        int end = page * rows;  
        //把总记录和当前记录写到前台  
        int total = userService.getAllUser().size(); //userMapper.findUsersList().size();  
        List<User> uList = userService.getUserByPage(start, end);//userMapper.findUsersListByPage(start, end);
        System.out.println("日志信息一定要长这样才看得见啊"+start);
        System.out.println("日志信息一定要长这样才看得见啊"+end);
        this.toBeJson(uList, total, response);  
    }
	
	 @RequestMapping("/addUser")  
	 public void addUser(HttpServletRequest request,User user){    
	        userService.insert(user);
	    }
	 
	 @RequestMapping(value="/deleteUser")
	 public void deleteUser(HttpServletRequest request){
		 int userId=Integer.parseInt(request.getParameter("userId"));
		 userService.deleteByPrimaryKey(userId);
	 }
	 
	 @RequestMapping(value="/updateUser")
	 public void updateUser(HttpServletRequest request,User user) throws UnsupportedEncodingException{  
	        userService.updateUserNameSelective(user);
	    }
	 
	 /**
	  * 知识审核及其它操作部分
	  */
	 @RequestMapping(value="/admin/knowledgeList")
	 public  void knowledgeList(int page,int rows,HttpServletResponse response,Model model) throws IOException{  
		 response.setContentType("application/json; charset=utf-8");  
	        //求得开始记录与结束记录  
	        int start = (page-1)*rows;  
	        int end = page * rows;  
	        //把总记录和当前记录写到前台  
	        int total = knowledgeService.getAllKnowledge().size(); //userMapper.findUsersList().size();  
	        List<KnowledgeWithBLOBs> kList = knowledgeService.getKnowledgeByPage(start, end);//userMapper.findUsersListByPage(start, end);
	        System.out.println("日志信息一定要长这样才看得见啊"+start);
	        System.out.println("日志信息一定要长这样才看得见啊"+end);
	        this.toBeJson(kList, total, response);    
	 }
}
