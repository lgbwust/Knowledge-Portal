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
				欢迎！&nbsp;${username} | <a href="<%=basePath%>loginout.do"><button name="logout" >注销</button></a>  
			</div>
		</div>
		<div id="header">
			<div class="f_search">
					<form method="post" action="searchresult.jsp">
						<p><input type="text" name="EKeywords" value="search..." class="search" onblur="if(this.value=='') this.value='search...';" onfocus="if(this.value=='search...') this.value='';" /> <input type="submit" value="Go" class="submit" /></p>
					</form>
			</div>
			<div class="title">
				<!--  <h1>囧之知识管理系统</h1>
				<h2>您的支持是我们前进最大的动力!</h2>-->
			</div>
		</div>
	
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
		您当前的位置 > 主页
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
            	
				<h2><a href="#">最新知识</a></h2>
				
				<h3>这里，您将看到最新上传的知识资料</h3>
			
				<div class="img"></div>
				
				
				
				<p class="date">上传者: <</p><br />
				<p></p>
				<h2><a href="#">知识列表</a></h2>
				<h3>这里，您将看到本站所有知识资料</h3>
				<div class="navlist" id="klist">
				<ul>
                	
                </ul>
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