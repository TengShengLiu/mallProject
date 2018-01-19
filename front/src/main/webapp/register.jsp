<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/views/common.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/login.css">
		<script type="text/javascript" src="${path}/static/js/register.js"></script>
	</head>
	<body>
		<form method="post">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="${path}/member/toMain" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" id="username" placeholder="请输入你的用户名"/><span style="color: #ff6700" id="s1">请不要输入汉字</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的密码"/><span style="color: #ff6700" id="s2">请输入6位以上字符</span></div>
					<div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" id="repassword" placeholder="请确认你的密码"/><span style="color: #ff6700" id="s3">两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="tel" id="tel" placeholder="请填写正确的手机号"/><span style="color: #ff6700" id="s4">填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl"><img src="${path}/static/image/yanzhengma.jpg"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="button" value="立即注册" onclick="register()" >
				</div>
				
			</div>
		</div>
		</form>
	</body>
</html>