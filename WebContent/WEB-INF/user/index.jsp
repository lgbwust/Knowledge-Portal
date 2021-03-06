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
	<div class="content">
		<div id="top">
			<div class="padding"> 
				欢迎！&nbsp;${username},${userId} | <a href="<%=basePath%>loginout.html"><button name="logout" >注销</button></a>  
			</div>
		</div>
		<div id="header">
			<div class="f_search">
					<form method="post" action="<%=basePath %>search.html">
						<p><input type="text" name="content" value="search..." class="search" onblur="if(this.value=='') this.value='search...';" onfocus="if(this.value=='search...') this.value='';" /> <input type="submit" value="Go" class="submit" /></p>
					</form>
			</div>
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
		您当前的位置 > 主页
			
			<div class="left_side">
  	
				<h2><a href="<%=basePath %>showinfo.html">知识列表</a></h2>
				
				<h3>这里，您将看到本站所有知识资料</h3>

            
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
<c:forEach items="${xx}" var="xx" varStatus="status">
<tr>
<td>${xx.kid}</td>
<td>${xx.user.getUserName()}</td>
<td>${xx.title}</td>
<td>${xx.content}</td>
<td>${xx.extra}</td>
<td>${xx.category.getCname()}</td>
<td>${xx.status}</td>
</tr>
</c:forEach>
</table>
		    
				<div class="img"></div>
				
				
				
				<p class="date">上传者: <</p><br />
				<p></p>
				<h2><a href="<%=basePath %>showFiles.html">文件列表</a></h2>
				<h3>这里，您将看到本站所有文件资料</h3>
				<div class="navlist" id="klist">
                     <table class="table table-bordered" style="font-family: 微软雅黑">
<tr>
<th style="text-align: center; width: 5%">文件编号</th>
<th style="text-align: center; width: 10%">上传者</th>
<th style="text-align: center; width: 10%">文件名</th>
<th style="text-align: center; width: 10%">文件说明</th>
<th style="text-align: center; width: 10%">文件状态</th>
</tr> 
<c:forEach items="${allFiles}" var="allFiles" varStatus="status">
<tr>
<td>${allFiles.fileId}</td>
<td>${allFiles.user.getUserName()}</td>
<td><a href="<%=basePath%>download.html?fileName=${allFiles.fileName}">${allFiles.fileName}</a></td>
<td>${allFiles.fileDes}</td>
<td>${allFiles.fileStatus}</td>
</tr>
</c:forEach>
</table>
                </div>
                
				<!--  <p class="date"><a href="#">1</a> | <a href="#">2</a> | <a href="#">3</a> |当前第1页</p><br /> -->

			</div>
		</div>
		
		<div id="footer">
			<div class="padding">
				Copyright &copy; 测试页面~
			</div>
		</div>
	</div>
</body>
</html>