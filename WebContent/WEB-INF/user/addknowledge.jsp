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
				<!--  <h1>此处添加title</h1>
				<h2>此处添加subtitle</h2>-->
			</div>
		</div>
		

    <div id="subheader">
			<div id="menu">
			  	<ul>
				    <li><a href="<%=basePath %>ind.do">主页</a></li>
					<li><a href="<%=basePath %>add.do">知识上传</a></li>
					<li><a href="<%=basePath %>sea.do">知识搜索</a></li>
					<li><a href="<%=basePath %>upl.do">文件上传</a></li>
					<li><a href="userinfo.jsp">个人信息</a></li>
      			</ul>
			</div>
		</div>
        
        <div id="main">
		您当前的位置 > <a href="<%=basePath %>ind.do">主页</a> > 知识上传
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
                 <form action="<%=basePath %>addknowledge.do" method="post">
							  
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
									<option value="1">Java</option>
                                    <option value="2">C++</option>
                                    <option value="3">dotnet</option>
                                    <option value="4">others</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                        	<td>附加说明</td>
                            <td><input type="text" name="extra_info" /></td>
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
	</div>	  
</body>
</html>