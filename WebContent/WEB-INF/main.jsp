<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>知识门户首页</title>
</head>
<body>
<center><h1>欢迎登录知识门户系统</h1></center>
<center>
<a href="<%=basePath%>btn1.html"><button>登入</button></a>
<a href="<%=basePath%>btn2.html"><button>注册</button></a>
<a href="<%=basePath%>btn3.html"><button>登入管理后台</button></a>
</center>
</body>
</html>