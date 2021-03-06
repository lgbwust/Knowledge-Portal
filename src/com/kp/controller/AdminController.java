package com.kp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kp.domain.Admin;
import com.kp.domain.File;
import com.kp.domain.KnowledgeWithBLOBs;
import com.kp.domain.SysMenu;
import com.kp.domain.User;
import com.kp.domain.easyui.Json;
import com.kp.domain.easyui.Tree;
import com.kp.service.AdminService;
import com.kp.service.FileService;
import com.kp.service.KnowledgeService;
import com.kp.service.UserService;
import com.kp.util.JsonUtil;

import net.sf.json.JSONObject;


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
	
	//每一个service都必须使用@Resource注解，否则会报错
	@Resource
	private AdminService adminService;
	@Resource
	private UserService userService;
	@Resource
	private FileService fileService;
	@Resource
	private KnowledgeService knowledgeService;

	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adminlogin")
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
			return "admin/index";
		}
		else{
			request.getSession().setAttribute("admsg", "登录失败,用户名或密码错误~~~ :)");
			return "admin/adminlogin";
			}
		//return "admin/adminlogin";
	}
	
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/adminloginout")
	public String adminloginout(HttpServletRequest request){
		request.removeAttribute("adname");
		return "admin/adminlogin";
	}
	
	/**
	 * 获取系统菜单
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/getMenu", method = RequestMethod.POST)
	@ResponseBody
	public  List<Tree> getMenu(HttpServletResponse response) throws IOException{
		List<SysMenu> menuList =adminService.getMenu();
		List<Tree> treeList = new ArrayList<Tree>();
		
		for (SysMenu menu : menuList) {
			Tree node = new Tree();
			BeanUtils.copyProperties(menu, node);
			if(menu.getParentId()!=0){	//有父节点
				node.setPid(menu.getParentId());
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getUrl());
			node.setAttributes(attr);
			treeList.add(node);
        }
    	return treeList; 
	}
	
	/**
	 * 跳转到用户表格页面
	 * @return
	 */
	@RequestMapping(value = "/user/userList",method = RequestMethod.GET)
    public String userList(Model model) {
        return "admin/userList";
    }
	
	/**
	 * 跳转到知识页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/kp/kpList",method = RequestMethod.GET)
    public String kpList(Model model) {
        return "admin/kpList";
    }
	
	/**
	 * 跳转到文件页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/file/fileList",method = RequestMethod.GET)
    public String fileList(Model model) {
        return "admin/fileList";
    }
	
	/**
	 * 显示用户列表
	 * @param page
	 * @param rows
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="/admin/userList")
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
	
	/**
	 * 添加用户
	 * @param request
	 * @param user
	 */
	 @RequestMapping("/admin/addUser")  
	 public void addUser(HttpServletRequest request,User user){    
		 //输出接收的参数
		 System.out.println("接收到的用户ID为："+user.getUserId());
		 System.out.println("接收到的用户名为："+user.getUserName());
		 System.out.println("接收到的密码为："+user.getUserPassword());
		 System.out.println("接收到的邮件："+user.getUserEmail());
		 
		 //添加到数据库
		 userService.insert(user);
	    }
	 
	 /**
	  * 删除用户
	  * @param request
	  */
	 @RequestMapping(value="/admin/deleteUser")
	 public void deleteUser(HttpServletRequest request){
		 int userId=Integer.parseInt(request.getParameter("userId"));
		 //test output
		 System.out.println("接收到的用户ID为："+userId);
		 
		 //del
		 userService.deleteByPrimaryKey(userId);
	 }
	 
	 /**
	  * 编辑用户
	  * @param request
	  * @param user
	  * @throws UnsupportedEncodingException
	  */
	 @RequestMapping(value="/admin/editUser")
	 public void updateUser(HttpServletRequest request,User user) throws UnsupportedEncodingException{ 
		 //输出接收的参数
		 System.out.println("接收到的用户ID为："+user.getUserId());
		 System.out.println("接收到的用户名为："+user.getUserName());
		 System.out.println("接收到的密码为："+user.getUserPassword());
		 System.out.println("接收到的邮件："+user.getUserEmail());
		 
		 //更新用户
	     userService.updateByPrimaryKey(user);
	    }
	 
	 /**
	  * 显示知识列表
	  * @param page
	  * @param rows
	  * @param response
	  * @param model
	  * @throws IOException
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
	        //System.out.println("日志信息一定要长这样才看得见啊"+start);
	        //System.out.println("日志信息一定要长这样才看得见啊"+end);
	        this.toBeJson(kList, total, response);    
	 }
	 
	 /**
	  * 编辑知识
	  * @param request
	  * @param kp
	  */
	 @RequestMapping(value="/admin/editKnowledge")
	 public void editKnowledge(HttpServletRequest request,KnowledgeWithBLOBs kp){
		 //输出接收的参数
		 System.out.println("接收到的ID为："+kp.getKid());
		 System.out.println("接收到的内容为："+kp.getContent());
		 System.out.println("接收到的附加信息为："+kp.getExtra());
		 System.out.println("接收到的标题为："+kp.getTitle());
		 
		 //更新数据库
		 knowledgeService.updateByPrimaryKeySelective(kp);
	 }
	 
	 /**
	  * 删除知识
	  * @param request
	  */
	 @RequestMapping(value="/admin/deleteKnowledge")
	 public void deleteKnowledge(HttpServletRequest request){
		 String id = request.getParameter("kid"); 
		 knowledgeService.deleteKnowledge(Integer.parseInt(id));
	 }
	 
	 /**
	  * 审核知识
	  * @param request
	  */
	 @RequestMapping(value="/admin/checkKnowledge")
	 public void checkKnowledge(HttpServletRequest request){
		 String id = request.getParameter("kid");  
		 //test log
		 System.out.println(id);
		 knowledgeService.checkKnowledge(Integer.parseInt(id));
	 }
	 
	 /**
	  * 显示文件列表
	  * @param page
	  * @param rows
	  * @param response
	  * @param model
	  * @throws IOException
	  */
	 @RequestMapping(value="/admin/fileList")
	 public void fileList(int page,int rows,HttpServletResponse response,Model model) throws IOException{
		 response.setContentType("application/json; charset=utf-8");  
	        //求得开始记录与结束记录  
	        int start = (page-1)*rows;  
	        int end = page * rows;  
	        //把总记录和当前记录写到前台  
	        int total = fileService.getAllFile().size(); //userMapper.findUsersList().size();  
	        List<File> fList = fileService.getFileByPage(start, end);//userMapper.findUsersListByPage(start, end);
	        System.out.println("日志信息一定要长这样才看得见啊"+start);
	        System.out.println("日志信息一定要长这样才看得见啊"+end);
	        this.toBeJson(fList, total, response); 
	 }
	 
	 /**
	  * 删除文件
	  * @param request
	  */
	 @RequestMapping(value="/admin/deleteFile")
	 public void deleteFile(HttpServletRequest request){
		 String id = request.getParameter("fileId"); 
		 //test output
		 System.out.println("接收到的文件ID为："+id);
		 
		 fileService.deleteByPrimaryKey(Integer.parseInt(id));
	 }
	 
	 /**
	  * 审核文件
	  * @param request
	  */
	 @RequestMapping(value="/admin/checkFile")
	 public void checkFile(HttpServletRequest request){
		 String id = request.getParameter("fileId");
		 //test output
		 System.out.println("接收到的文件ID为："+id);
		 
		 fileService.checkFile(Integer.parseInt(id));
	 }
}
