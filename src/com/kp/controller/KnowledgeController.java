package com.kp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kp.domain.KnowledgeWithBLOBs;
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
	
	//添加知识点
	@RequestMapping(value="/addknowledge",method=RequestMethod.POST)
	public ModelAndView  addKnowledge(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String kname=(String)request.getParameter("kname");     
        int ktype=Integer.parseInt(request.getParameter("ktype"));       
        String content=(String)request.getParameter("content"); 
        String extra=(String)request.getParameter("extra_info"); 
        int userId=(int) request.getSession().getAttribute("userId");
        int status = 0;
        //if(username==null||email==null||password==null){  
         //   return new ModelAndView("redirect:/user/register");   
       //}  
        //新增知识插入数据库  
        KnowledgeWithBLOBs kd=new KnowledgeWithBLOBs();
        kd.setCid(ktype);
        kd.setTitle(kname);
        kd.setContent(content);
        kd.setExtra(extra);
        kd.setUserId(userId);
        kd.setStatus(status); //新插入数据的状态统一设为待审核
        try{
        	knowledgeService.insertSelective(kd);       
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        //将数据转换成  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("username", kname);    
        map.put("email", ktype);    
        map.put("password", content);
        map.put("password", extra); 
/*      String json = JSONObject.fromObject(map).toString();         
        //将数据返回 
        response.setCharacterEncoding("UTF-8"); 
        response.flushBuffer(); 
        response.getWriter().write(json); 
        response.getWriter().flush();   
        response.getWriter().close();*/  
        return new ModelAndView("user/addResult",map);    
    }
	//知识点展示功能实现
	@RequestMapping(value="/showinfo")
	public String showKnowledge(HttpServletRequest request){
		List<KnowledgeWithBLOBs> xx= knowledgeService.selectByPrimaryKey(3);
		//List<KnowledgeWithBLOBs> xx=knowledgeService.listKnowledge(0);
		request.setAttribute("xx",xx);
		return "user/index";
	}
}

