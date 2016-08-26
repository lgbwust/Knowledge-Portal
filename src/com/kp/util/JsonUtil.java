package com.kp.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class JsonUtil {
	/**
     * 把数据写到前台
     * 需要导入jar包
     * @param obj 要写的数据
     * @param response 
     */
	public void toBeJson(List list,int total,HttpServletResponse response) throws IOException{
		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", total);
		jobj.accumulate("rows", list);
		
		response.setCharacterEncoding("utf-8");//指定为utf-8
        response.getWriter().write(jobj.toString());//转化为JSOn格式
		
	}
}