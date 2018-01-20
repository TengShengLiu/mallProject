<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>小米6立即购买-小米商城</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/style.css">
		<script type="text/javascript" src="${path}/static/js/xiangqing.js"></script>
	</head>
	<body>

	<%@include file="head.jsp"%>
	<!-- xiangqing -->
	<form action="post" method="">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">小米6</div>
			<nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">变焦双摄</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">参数</a></li>
				<li>|</li>
				<li><a href="">F码通道</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="${path}${requestScope.product.url}" height="562px" width="562px"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${requestScope.product.pName}</div>
			<div class="jianjie mr40 ml20 mt10">${requestScope.product.comments}</div>
			<div class="jiage ml20 mt10">￥${requestScope.product.selPrice}</div>
			<input hidden="hidden" name="pid" id="pid" value="${requestScope.product.pid}">


			<%--<div class="ft20 ml20 mt20">选择版本</div>--%>
			<%--<div class="xzbb ml20 mt10">--%>
				<%--<div class="banben fl">--%>
					<%--<a>--%>
						<%--<span>全网通版 6GB+64GB </span>--%>
						<%--<span>2499元</span>--%>
					<%--</a>--%>
				<%--</div>--%>
				<%--<div class="banben fr">--%>
					<%--<a>--%>
						<%--<span>全网通版 6GB+128GB</span>--%>
						<%--<span>2899元</span>--%>
					<%--</a>--%>
				<%--</div>--%>
				<%--<div class="clear"></div>--%>
			<%--</div>--%>
			<%--<div class="ft20 ml20 mt20">选择颜色</div>--%>
			<%--<div class="xzbb ml20 mt10">--%>
				<%--<div class="banben">--%>
					<%--<a>--%>
						<%--<span class="yuandian"></span>--%>
						<%--<span class="yanse">亮黑色</span>--%>
					<%--</a>--%>
				<%--</div>--%>
				<%----%>
			<%--</div>--%>

			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
					<div class="left1 fl">数量：</div>
					<div class="right1 fr"><input class="shuliang" id="count" type="number" value="1" step="1" min="1"/></div>
					<div class="clear"></div>
				</div>
				<div class="bot mt20 ft20 ftbc">总计：2499元</div>
			</div>
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" onclick="shop()"/>
					<input class="jrgwc" type="button" name="jrgwc" value="加入购物车" onclick="addToCart()"/>
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	<!-- footer -->
	<footer class="mt20 center">
			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

		</footer>

	</body>
</html>