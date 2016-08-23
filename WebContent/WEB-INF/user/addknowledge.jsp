<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>用户页面</title>
</head>
<body>
<center>  
<h1><b>欢迎回来~</b></h1>  
用户名：${username}<br>    
邮箱：${email}<br>
<a href="<%=basePath%>loginout.do"><button name="logout" >注销</button></a>  
</center>

    <div id="subheader">
			<div id="menu">
			  	<ul>
				    <li><a href="<%=basePath %>ind.do">主页</a></li>
					<li><a href="<%=basePath %>add.do">知识上传</a></li>
					<li><a href="<%=basePath %>sea.do">高级搜索</a></li>
					<li><a href="<%=basePath %>upl.do">文件上传</a></li>
					<li><a href="userinfo.jsp">个人信息</a></li>
      			</ul>
			</div>
		</div>
        
        <div id="main">
		您当前的位置 > <a href="index.jsp">主页</a> > 知识上传
			<div class="right_side">
				
				<div class="nav">
				<h2>推荐知识</h2>
					<ul>
					
					</ul>
				
				<h2>知识贡献排行</h2>
					<ul>
						
					</ul>
				
					
					<br />
					<h2>最近登录</h2>
					<ul>
					
						
					</ul>
				
				
				</div>
			</div>
			<div class="left_side">
            	
				<h2><a href="#">新知识上传</a></h2>
				<h3>知识系统的壮大，需要每个会员的支持</h3>
                <div class="register">
                 <form action="uploadSubmit.jsp" method="post">
							  
                	<table border="0" cellspacing="0">
               	    	<tr>
                        	<td>*知识名：</td>
                            <td><input type="text" name="kname" id="user"" /></td>
                        </tr>
                        <tr>
                        	<td>*知识类别：</td>
                            <td>
                            	<select name="ktype">
                                	<option value="Default">选择分类</option>
									
                                </select>
                            </td>
                        </tr>
                        <tr>
                        	<td>关键词：</td>
                            <td><input type="text" name="kkeyword" /></td>
                            <td><span id="kkeywordspan">逗号分隔</span></td>
                        </tr>
                        <tr>
                        	<td>版本号：</td>
                            <td><input type="text" name="kversion" /></td>
                        </tr>
                        <tr>
                        	<td>介绍图片：</td>
                            <td><input type="text" name="kpth" /></td>
                        </tr>
                        
                        </table>
                        <p>知识正文：</p>
                       <textarea name="content" style="width:100%;height:350px;"></textarea>
					   <script type="text/javascript">
			        	//<![CDATA[

					    // This call can be placed at any point after the
					    // <textarea>, or inside a <head><script> in a
					    // window.onload event handler.

					    // Replace the <textarea id="editor"> with an CKEditor
					    // instance, using default configurations.
					    CKEDITOR.replace( 'content' );

				       //]]>
				      </script>
                        <table border="0">
                        <tr>
                        	<td style="width:75%"></td>
                            <td align="right">
                            	<input type="submit" value="提交" />
                                <input type="reset" value="重置" />
                            </td>
                        </tr>
                    </table>
                </form>
				</div>
                
				
			
			</div>
		</div>
		
		<div id="footer">
			<div class="padding">
				Copyright &copy; 测试页面~
			</div>
		</div>
		  
</body>
</html>