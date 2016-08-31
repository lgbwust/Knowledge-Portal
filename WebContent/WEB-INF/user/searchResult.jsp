<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>搜索结果</title>
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
		您当前的位置 > <a href="<%=basePath %>ind.html">主页</a> > 知识搜索结果
		</div>
		<div class="left_side">
		
		<table class="table table-bordered" style="font-family: 微软雅黑">
<tr>
<th style="text-align: center; width: 5%">知识编号</th>
<th style="text-align: center; width: 10%">上传者</th>
<th style="text-align: center; width: 10%">知识标题</th>
<th style="text-align: center; width: 10%">知识内容</th>
<th style="text-align: center; width: 10%">附加说明</th>
<th style="text-align: center; width: 10%">知识类别</th>
<th style="text-align: center; width: 10%">知识状态</th>
</tr> 
<c:forEach items="${res}" var="res" varStatus="status">
<tr>
<td>${res.kid}</td>
<td>${res.user.getUserName()}</td>
<td>${res.title}</td>
<td>${res.content}</td>
<td>${res.extra}</td>
<td>${res.category.getCname()}</td>
<td>${res.status}</td>
</tr>
 </c:forEach>
   </table>
</div>
		<div id="footer">
			<div class="padding">
				Copyright &copy; 测试页面
			</div>
		</div>
		</div>
</body>
</html>