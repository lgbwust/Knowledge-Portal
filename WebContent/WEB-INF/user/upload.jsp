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
<title>文件上传</title>
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
		您当前的位置 > <a href="<%=basePath %>ind.html">主页</a> > 文件上传
			
			<div class="left_side">
            	
				<h2><a href="#">文件上传</a></h2>
				<h3>欢迎上传文件</h3>
                <div class="register">
                <form action="<%=basePath %>uploadFile.html" method="post" enctype="multipart/form-data">
                	<table border="0" cellspacing="0">
                        <tr>
                        	<td>文件说明</td>
                            <td><input type="text" name="extraInfo" /></td>
                        </tr>
                        
                         <tr>
                        	<td>上传文件</td>
                            <td><input type="file" name="myfiles" /></td>
                        </tr>
                        
                        </table>
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
				Copyright &copy; 测试页面
			</div>
		</div>
	</div>
</body>
</html>