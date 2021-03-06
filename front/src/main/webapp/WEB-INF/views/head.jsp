<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>小米商城</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="${path}/product/toCart">购物车</a></div>
					<div class="fr">
						<ul>
							<c:choose>
								<c:when test="${sessionScope.member == null}">
									<li><a href="${path}/login.jsp" target="_blank">登录</a></li>
									<li>|</li>
									<li><a href="${path}/register.jsp" target="_blank" >注册</a></li>
									<li>|</li>
								</c:when>
								<c:otherwise>
									<li>|</li>
									<li><a href="${path}/orders/getAll" target="_blank" >个人中心</a></li>
									<li>|</li></c:otherwise>
							</c:choose>


							<li><a href="">消息通知</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="${path}/toMain" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="/liebiao.html" target="_blank">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="${path}/search/search" method="post">
					<div class="text fl">
						<input type="text" id="pageInfo" class="shuru" value="${requestScope.info}" name="info" placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
	</body>
</html>