<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
	<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>
	<link rel="shortcut icon" href="img/icon.png">
	<script type='text/javascript' src="js/jquery-1.12.3.min.js"></script>
	<script type='text/javascript' src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
	
	$(function(){           
        $('#kaptchaImage').click(function () {//生成验证码  
         $(this).hide().attr('src', '<%=basePath%>captcha-image.do?' + Math.floor(Math.random()*100) ).fadeIn(); })      
              }); 	
	
		$(function(){
    	// $('#loginModal').modal({
     //      backdrop: 'static'
     //    });

		$("#userName").focus(function(){
			$("#message").html("");
		});

		$("#passWord").focus(function(){
			$("#message").html("");
		});
	});

	function toLogin(){
		var userName=document.getElementById("userName").value;
	    var passWord=document.getElementById("userpsw").value;
	    var kaptcha=document.getElementById("kaptcha").value;
	    
    if ((userName==null||userName=="")) {
        $("#message").html("账号为空，请检查后输入");
        return false;
    };
    if ((userpsw==null||userpsw=="")) {
        $("#message").html("密码为空，请检查后输入");
        return false;
    };
    if ((kaptcha==null||kaptcha=="")) {
        $("#message").html("验证码为空，请检查后输入");
        return false;
    };
			
   // $.post("../userlogin.do",{userName:userName,passWord:passWord});
}
	</script>
	<style type="text/css">
		.message{
			color: red
		}
		#dropdownMenu1, [role=presentation]{
			width:220px;
		}
	</style>
</head>
<body>

 <form onsubmit="return toLogin()" action="<%=basePath%>login.do" method="post" class="form-horizontal" >
 <div class="container">
		<div class="row">
			<div class="span12">


				<div class="modal show" id="loginModal" aria-hidden="true">
					<div class="modal-header">
						<h2>用户登录</h2>
					</div>
					<div class="modal-body">
						
							<div class="control-group">
								<label class="control-label" for="phone">用户名</label>
								<div class="controls">
									<input type="text" name="userName" id="userName" placeholder="账号" style="width:200px;height:30px;">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="psw">密码</label>
								<div class="controls">
									<input type="password" name="userpsw" id="userpsw"
									placeholder="密码" style="width:200px;height:30px;">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="test">验证码</label>
								<div class="controls">
									 <input name="kaptcha" type="text" id="kaptcha" maxlength="4" placeholder="验证码" style="width:200px;height:30px;" />  
									 <img src="<%=basePath%>captcha-image.do"  id="kaptchaImage" title="看不清，点击换一张" />    
                                      
								</div>
							</div>
					</div>
					<c:if test="${msg!=null}">
									${msg}
								</c:if>
					<div class="modal-footer">
						<div id="message" class="pull-left message"></div>
						<input type="submit" class="btn btn-primary" name="submit" value="登录"/>
						<!--<button type="button" class="btn btn-primary" onclick="toLogin();">&nbsp;登录&nbsp;</button>
						 <a href="../foryou/user/forgetPassword.do" target="_blank"class="inline">Forget password?</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
 </form>
</body>
</html>