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
<title>文件上传结果</title>
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
		您当前的位置 > <a href="<%=basePath %>ind.html">主页</a> > 文件添加结果
		</div>
		<div class="left_side">
		<h2>文件上传成功，待管理员审核通过后将显示在主页上</h2>
		</div>
		<div id="footer">
			<div class="padding">
				Copyright &copy; 测试页面
			</div>
		</div>
		</div>
</body>
</html>