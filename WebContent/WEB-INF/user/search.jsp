<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>知识搜索</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="content">
		<div id="top">
			<div class="padding">
				欢迎！&nbsp; ${username} | <a href="<%=basePath%>loginout.html"><button name="logout" >注销</button></a>
			</div>
		</div>
		<div id="header">
			
			<div class="title">
				<!--  <h1>此处添加title</h1>
				<h2>此处添加subtitle</h2>-->
				<h1>知识门户</h1>
			</div>
		</div>
	
		
        <div id="subheader">
			<div id="menu">
			  	<ul>
					<li><a href="<%=basePath %>ind.html">主页</a></li>
					<li><a href="<%=basePath %>add.html">知识上传</a></li>
					<li><a href="<%=basePath %>sea.html">知识搜索</a></li>
					<li><a href="<%=basePath %>upl.html">文件上传</a></li>
      			</ul>
			</div>
		</div>
        
		
		<div id="main">
		您当前的位置 > <a href="index.jsp">主页</a> > 知识搜索
		
			<div class="left_side">
            	
				<h2><a href="#">知识搜索</a></h2>
				<h3>搜索</h3>
                <div class="register">
                <form action="<%=basePath %>search.html" method="post">
                	<table border="0" cellspacing="20">              	    
                        <tr>
                        	<td>搜索内容：</td>
                        	<td><input type="text" name="content" id="content" /></td>
                        </tr>
                      
                        <tr>
                        	<td></td>
                        	<td align="right"><input type="submit" value="搜索" /></td>
                        </tr>
                    </table>
                </form>
				</div>
                
				
			
			</div>
		</div>
		
		<div id="footer">
			<div class="padding">
				Copyright &copy; 测试页面
			</div>
		</div>
	</div>
</body>
</html>