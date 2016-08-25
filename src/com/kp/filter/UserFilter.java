package com.kp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器测试
 * @author fiberhome
 * @date 2016年8月25日  下午3:32:53
 */
public class UserFilter extends HttpServlet implements Filter{
	// 需要定义系统页面访问中可放行的连接  
    private List<String> list = new ArrayList<String>();  
  
    public void init(FilterConfig arg0) throws ServletException {  
        list.add("/main.jsp");  
        list.add("/mainPage.do");  
    }  
  
    public void doFilter(ServletRequest servletRequest,  
            ServletResponse servletResponse, FilterChain chain)  
            throws IOException, ServletException {  
        HttpServletRequest request = (HttpServletRequest) servletRequest;  
        HttpServletResponse response = (HttpServletResponse) servletResponse;  
        // 1、获取页面中的访问的路径连接  
        String path = request.getServletPath();  
        if (list != null && list.contains(path)) {  
            // 如果页面中获取的访问连接于定义的可放行的连接一致，则放行  
            chain.doFilter(request, response);  
            return;  
        }  
        // 2、从session(flag)对象中获取当前登录的用户标志  
        String flag = (String) request.getSession().getAttribute("username");  
        if (flag != null) {  
            // 如果从session中获取的用户对象不为空，则放行  
            chain.doFilter(request, response);  
            return;  
        }  
        // 如果不满足条件1和2，则不能放行，回到系统的登录页面  
        response.sendRedirect(request.getContextPath() + "/");  
    }  
  
    public void destroy() {  
  
    }  
}
