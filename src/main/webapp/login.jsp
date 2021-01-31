<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>旅游网-登录</title>  
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
      <!--导入angularJS文件-->
    <script src="js/angular.min.js"></script>
	<!--导入jquery-->
	<script src="js/jquery-3.3.1.js"></script>
</head>

<body>

	<%
		String username = null;
		String password = null;
		Cookie [] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie!=null){
					if(cookie.getName().equals("username")){
						username = URLDecoder.decode(cookie.getValue(),"UTF-8");
					}
					if(cookie.getName().equals("password")){
						password = cookie.getValue();
					}
				}
			}
		}
		if(username!=null && password!=null){
			request.getRequestDispatcher(request.getContextPath()+"user?method=login&code=free&username="+username+"$password="+password).forward(request,response);
		}


	%>


<!--引入头部-->
<div id="header"></div>
    <!-- 头部 end -->
    <section id="login_wrap">
        <div class="fullscreen-bg" style="background: url(images/login_bg.png);height: 532px;">
        	
        </div>
        <div class="login-box">
        	<div class="title">
        		<img src="images/login_logo.png" alt="">
        		<span>欢迎登录旅游账户</span>
        	</div>
        	<div class="login_inner">
				
				<!--登录错误提示消息-->
        		<div id="errorMsg" class="alert alert-danger" ></div>
				<form id="loginForm" action="${path}/user?method=login" method="post" accept-charset="utf-8">
        			<input type="hidden" name="action" value="login"/>
					<input name="username" type="text" placeholder="请输入账号" autocomplete="off">
        			<input name="password" type="text" placeholder="请输入密码" autocomplete="off">
					<div class="col-sm-6">
						<span id="msg" style="color: red">${msg}</span>
					</div>
        			<%--<div class="verify">
					<input name="check" type="text" placeholder="请输入验证码" autocomplete="off">
					<span><img src="checkCode" alt="" onclick="changeCheckCode(this)"></span>
						<script type="text/javascript">
							//图片点击事件
							function changeCheckCode(img) {
								img.src="checkCode?"+new Date().getTime();
							}
						</script>
			</div>--%>
			<div class="submit_btn">
        				<%--<button type="button" >登录</button>--%>
				<input type="submit" name="submit" style="width:300px;height: 40px " value="登录">
        				<div class="auto_login">
        					<input type="checkbox" name="free" class="checkbox">
        					<span>自动登录</span>
        				</div>        				
        			</div>        			       		
        		</form>
        		<div class="reg">没有账户？<a href="register.jsp">立即注册</a></div>
        	</div>
        </div>
    </section>
    <!--引入尾部-->
    <div id="footer"></div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <!--导入布局js，共享header和footer-->
    <script type="text/javascript" src="js/include.js"></script>
</body>

</html>