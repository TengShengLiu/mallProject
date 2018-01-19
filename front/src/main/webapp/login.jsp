<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/views/common.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会员登录</title>
		<script src="${path}/static/js/member.js"></script>
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="main" target="_blank"><img src="${path}/static/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="${path}/register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input class="shurukuang" id="username" type="text" name="username" placeholder="请输入你的用户名"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" id="password" type="password" name="password" placeholder="请输入你的密码"/></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl"><img src="${path}/static/image/yanzhengma.jpg"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="login_submit">
					<input class="submit" type="button" value="立即登录" onclick="login()"/>
				</div>
				
			</div>
		</div>
		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="${path}/static/image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>

		</footer>
	</body>
</html>