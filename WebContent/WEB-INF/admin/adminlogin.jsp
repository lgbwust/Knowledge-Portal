<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src="/js/jquery-1.12.3.min.js"></script>
<title>管理员登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/adminlogin.do" method="post">
<table width="300" border="1" align="center">
    <tr>
      <td colspan="2">管理员登录</td>
    </tr>
    <tr>
      <td>用户名:</td>
      <td><input type="text" name="adminName">
      </td>
    </tr>
    <tr>
      <td>密码:</td>
      <td><input  type="password" name="adminPsw"/>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" name="submit" value="登录"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>