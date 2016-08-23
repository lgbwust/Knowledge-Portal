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
				欢迎！&nbsp; ${username} | <a href="<%=basePath%>loginout.do"><button name="logout" >注销</button></a>
			</div>
		</div>
		<div id="header">
			
			<div class="title">
				<!-- <h1>囧之知识管理系统</h1>
				<h2>您的支持是我们前进最大的动力!</h2> -->
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
		您当前的位置 > <a href="index.jsp">主页</a> > 高级搜索
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
            	
				<h2><a href="#">高级搜索</a></h2>
				<h3>普通搜索为普通用户服务，高级搜索为高级用户服务</h3>
                <div class="register">
                <form action="searchresult.jsp" method="post">
                	<table border="0" cellspacing="20">
               	    	<tr>
                        	<td>关键字：</td>
                            <td><input type="text" name="EKeywords" id="user"" /></td>
                        </tr>
                        <tr>
                        	<td>知识名称：</td>
                        	<td><input type="text" name="EName" id="" /></td>
                        </tr>
                        <tr>
                        	<td>上传时间：</td>
                        	<td><input type="text" name="EDate" id="" /></td>
                        </tr>
                        <tr>
                        	<td>作者：</td>
                        	<td><input type="text" name="username" /></td>
                        </tr>
                        <tr>
                        	<td>知识类别：</td>
                            <td>
                            	<select name="HName">
                                	<option value="Java">Java</option>
                                    <option value="C++">C++</option>
                                    <option value="dotnet">dotnet</option>
                                    <option value="others">others</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                        	<td>每页显示：</td>
                            <td>
                            	<select name="kpagenum">
                                	<option value="10">10条记录</option>
                                    <option value="100">100条记录</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                        	<td>版本号：</td>
                        	<td><input type="text" name="EVersion" /></td>
                        </tr>
                        <tr>
                        	<td></td>
                        	<td align="right"><input type="submit" value="提交" /></td>
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