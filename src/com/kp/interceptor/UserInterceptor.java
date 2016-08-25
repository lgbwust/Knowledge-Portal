package com.kp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能：防止用户注销或者没有登录的情况下访问页面
 * @author fiberhome
 * @date 2016年8月25日  下午1:12:47
 */
public class UserInterceptor implements HandlerInterceptor {
	private final Logger log = LoggerFactory.getLogger(UserInterceptor.class);
	/*
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) 
			throws Exception{
		String username=(String) request.getSession().getAttribute("username");
		if(username==null){
			log.info("Interceptor：跳转到login页面！");
			//response.sendRedirect(request.getContextPath()+"/user/login");
			request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
            return false;
		}
		else
		return true;
	}
	
	   /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作   
     * 可在modelAndView中加入数据，比如当前时间
     *
    public void postHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {   
        log.info("==============执行顺序: 2、postHandle================");  
        if(modelAndView != null){  //加入当前时间  
            modelAndView.addObject("var", "测试postHandle");  
        }  
    }  
  
    /** 
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等  
     *  
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     *
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
        log.info("==============执行顺序: 3、afterCompletion================");  
    }  
    */

	@Override  
	public boolean preHandle(HttpServletRequest request,  
	        HttpServletResponse response, Object handler) throws Exception { 
		
		System.out.println("Pre-handle");  
		String username=(String) request.getSession().getAttribute("username");
		if(username==null){
			log.info("Interceptor：跳转到login页面！");
			//response.sendRedirect(request.getContextPath()+"/user/login");
			request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
            return false;
		}
		else
		return true; 
	}  
	  
	@Override  
	public void postHandle(HttpServletRequest request,  
	        HttpServletResponse response, Object handler,  
	        ModelAndView modelAndView) throws Exception {  
	    System.out.println("Post-handle");  
	}  
	  
	@Override  
	public void afterCompletion(HttpServletRequest request,  
	        HttpServletResponse response, Object handler, Exception ex)  
	        throws Exception {  
	    System.out.println("After completion handle");  
	}  
}
