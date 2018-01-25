<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/style.css">
		<style type="text/css">
			.page{
				text-align: center;
				margin-top: 50px;
				float: right;
			}
			.page a,.page span {
				text-decoration: none;
				border: 1px solid #000000;
				padding: 5px 7px;
				color: #000000;
				cursor: pointer;
			}
			.page a:hover,.page span:hover{
				color: red;
			}

			hr{
				margin: 2px;
			}

		</style>
	</head>
	<body>
	<%@include file="head.jsp"%>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="${path}/orders/getAll" style="color:#ff6700;font-weight:bold;">全部订单</a></li>
					<li><a href="${path}/cart/getUnPay">待付款</a></li>
					<li><a href="${path}/orders/getUnSend">待发货</a></li>
					<li><a href="${path}/orders/getUnReceive">待签收</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="${path}/product/selfInfo">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">优惠券</a></li>
					<li><a href="">收货地址</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>


			<c:forEach items="${requestScope.orders}" var="order" >
				<div class="ddxq">
					<c:forEach items="${requestScope.orderDetails}" var="orderDetail">
						<c:if test="${order.id == orderDetail.oid}">
						<%--<div class="ddspt fl"><img src="${path}/${orderDetail.url}" alt=""></div>--%>
						<div class="ddbh fl">订单号:${order.id}</div>
						<div class="ztxx fr">
							<ul>
								<c:choose>
									<c:when test="${order.status == 0}">
										<li>未发货</li>
									</c:when>
									<c:when test="${order.status == 1}">
										<li>已发货，待签收</li>
									</c:when>
									<c:when test="${order.status == 2}">
										<li>已签收</li>
									</c:when>
								</c:choose>


								<li>￥${orderDetail.price}</li>
								<li>${order.date}</li>
								<li><a href="">订单详情></a></li>
								<div class="clear"></div>
							</ul>
						</div>
						<div class="clear"></div>
						</c:if>
					</c:forEach>
					<hr/>
				</div>
			</c:forEach>




			<%--<div class="ddxq">
				<div class="ddspt fl"><img src="${path}/static/image/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">订单号:1705205643098724</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥2499.00</li>
						<li>2017/05/20 13:30</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>

			<div class="ddxq">
				<div class="ddspt fl"><img src="${path}/static/image/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl">订单号:170526435444865</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥1999.00</li>
						<li>2017/05/26 14:02</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<hr/>
			<div class="ddxq">
				<div class="ddspt fl"><img src="${path}/static/image/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl">订单号:170526435444865</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥1999.00</li>
						<li>2017/05/26 14:02</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>--%>





			<div class="page">
				<span><a>上一页</a></span>
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<span><a>下一页</a></span>
			</div>

		</div>

		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>