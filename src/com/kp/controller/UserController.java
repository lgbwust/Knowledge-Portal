package com.kp.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kp.domain.User;
import com.kp.service.UserService;


@Controller 
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
    @RequestMapping(value="/checkUserName",method = RequestMethod.POST)  
    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String userName=(String)request.getParameter("userName");             
        //检验用户名是否存在   
        User user=userService.findByUserName(userName);
        boolean flag=false;
        if(user!=null){
        	flag=true;
        }
        System.out.println(flag);
        //将数据转换成json  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("flag", flag);              
        String json = JSONObject.fromObject(map).toString();          
        //将数据返回  
        response.setCharacterEncoding("UTF-8");  
        response.flushBuffer();  
        response.getWriter().write(json);  
        response.getWriter().flush();    
        response.getWriter().close();  
        return null;  
    }
    
    @RequestMapping(value="/checkEmail",method = RequestMethod.POST)  
    public String checkUserEmail(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String userEmail=(String)request.getParameter("email");             
        //检验用户名是否存在   
        User user=userService.findByEmail(userEmail);
        boolean flag=false;
        if(user!=null){
        	flag=true;
        }
        System.out.println(flag);
        //将数据转换成json  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("flag", flag);              
        String json = JSONObject.fromObject(map).toString();          
        //将数据返回  
        response.setCharacterEncoding("UTF-8");  
        response.flushBuffer();  
        response.getWriter().write(json);  
        response.getWriter().flush();    
        response.getWriter().close();  
        return null;  
    } 
   
    @RequestMapping(value="/register")  
    public ModelAndView  successed(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String username=(String)request.getParameter("username");     
        String email=(String)request.getParameter("email");       
        String password=(String)request.getParameter("password");  
        if(username==null||email==null||password==null){  
            return new ModelAndView("redirect:/user/register");   
        }  
        //新增用户插入数据库  
        User user=new User();  
        user.setUserName(username);  
        user.setUserEmail(email);  
        user.setUserPassword(password);  
        userService.insert(user);         
        //将数据转换成  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("username", username);    
        map.put("email", email);    
        map.put("password", password);    
/*      String json = JSONObject.fromObject(map).toString();         
        //将数据返回 
        response.setCharacterEncoding("UTF-8"); 
        response.flushBuffer(); 
        response.getWriter().write(json); 
        response.getWriter().flush();   
        response.getWriter().close();*/  
        return new ModelAndView("user/successed",map);    
    } 
    
    @RequestMapping(value="/login")
    public String Userlogin(User user, HttpServletRequest request, RedirectAttributes redirectAttributes,
			@RequestParam(value = "kaptcha", required = true) String kaptchaReceived) {

		// test output
    	String psw = request.getParameter("userpsw");
		System.out.println("username:" + user.getUserName());
		System.out.println("password:" + psw);
		System.out.println("password:" + user.getUserPassword());

		User dbuser = userService.findByUserName(user.getUserName());
		String kaptchaExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
			request.getSession().setAttribute("msg", "您输入的验证码错误~~~ :)");
			return "user/login";
		} else if (dbuser != null && dbuser.getUserPassword().equals(psw)) {
			// 保存用户信息	
			//userService.updateUserNameSelective(dbuser);
			request.getSession().setAttribute("username", dbuser.getUserName());
			request.getSession().setAttribute("email", dbuser.getUserEmail());
			return "user/index";
		}

		request.getSession().setAttribute("msg", "登录失败,用户名或密码错误~~~ :)");

		return "user/login";
	}
    /*
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String testLogin(HttpServletRequest request,@RequestParam String userName, @RequestParam String userpsw,
    		@RequestParam(value = "kaptcha", required = true) String kaptchaReceived) {
    	User user = userService.findByUserName(userName);
    	
    	//test output
    	System.out.println("username:" + user.getUserName());
    	System.out.println("password:" + user.getUserPassword());
    	String kaptchaExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
    	if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
			//request.getSession().setAttribute("Msg", "您输入的验证码错误~~~ :)");
			//return "user/loginStatus";
    		request.getSession().setAttribute("msg", "验证码错误，请重新输入");
    		return "user/login"; 
		}
    	else if(user!=null){
//    		log.info("user在数据库的密码是："+user.getPassword());   
//    		log.info("登录时输入加密的密码是："+DigestUtils.md5Hex(password));   
    		if(user.getUserPassword() != null){
    			request.getSession().setAttribute("user", userName);  
    			return "redirect:/mainPage.do";//跳转至访问页面
    		}else{ 
        		request.getSession().setAttribute("msg", "用户名密码错误，请重新登录");
        		return "user/login"; 
    		}
    	}else{
    		request.getSession().setAttribute("msg", "用户名不存在，请重新登录");
    		return "user/login"; 
    	}
    }
    */
    /**
     * 注销登录
     * 移除session
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginout")
	public String LoginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "user/login";
	}
}
