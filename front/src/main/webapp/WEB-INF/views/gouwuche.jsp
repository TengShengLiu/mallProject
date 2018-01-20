<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-小米商城</title>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/style.css">
		<script type="text/javascript" src="${path}/static/js/gouwuche.js"></script>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
					<li><a href="./login.html" target="_blank">登录</a></li>
					<li>|</li>
					<li><a href="./register.html" target="_blank">注册</a></li>	
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<%--<input type="checkbox" value="quanxuan" class="quanxuan" />全选--%>
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>

				<c:set var="sum" value="0" />
				<c:forEach items="${requestScope.products}" var="product" varStatus="abc">
					<div class="content2 center">
						<input value="${product.pid}" hidden="hidden" id="pid${abc.count}" name="pid"/>
						<input value="${sessionScope.member.mid}" hidden="hidden" id="mid${abc.count}" name="mid"/>
						<div class="sub_content fl ">

							<%--<c:if test="${product.type==0}">checked="checked" value="0"</c:if>--%>

							<input type="checkbox" id="checkbox${abc.count}"  class="quanxuan"
									<c:choose>
										<c:when test="${product.type==0}">checked="checked" value="1"</c:when>
										<c:when test="${product.type==1}">value="0"</c:when>
									</c:choose>
								   onchange="dropProduct(${abc.count})"/>
						</div>
						<div class="sub_content fl"><img src="${path}/${product.URL}" height="80px" width="80px"></div>
						<div class="sub_content fl ft20">${product.pname}</div>
						<div class="sub_content fl ">${product.SELPRICE}元</div>
						<div class="sub_content fl">
							<input class="shuliang" id="count${abc.count}" type="number" value="${product.count}" step="1" min="1" onchange="updataCount(${abc.count})"/>
						</div>
						<div class="sub_content fl">${product.SELPRICE*product.count}</div>
						<div class="sub_content fl"><a href="javascript:void(0);" id="${abc.count}" onclick="delProductIncart(${abc.count})">×</a></div>
						<div class="clear"></div>
					</div>
					<c:set var="sum" value="${sum+product.SELPRICE*product.count}"/>
					<c:set var="num" value="${abc.count}"/>
				</c:forEach>


				<%--<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img src="${path}/static/image/gwc_xiaomi6.jpg"></div>
					<div class="sub_content fl ft20">小米6全网通6GB内存+64GB 亮黑色</div>
					<div class="sub_content fl ">2499元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="1" step="1" min="1" >
					</div>
					<div class="sub_content fl">2499元</div>
					<div class="sub_content fl"><a href="">×</a></div>
					<div class="clear"></div>
				</div>
				<div class="content2 center">
					<div class="sub_content fl ">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div class="sub_content fl"><img src="${path}/static/image/gwc_xiaomi6.jpg"></div>
					<div class="sub_content fl ft20">小米6全网通6GB内存+64GB 亮黑色</div>
					<div class="sub_content fl ">2499元</div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="1" step="1" min="1" >
					</div>
					<div class="sub_content fl">2499元</div>
					<div class="sub_content fl"><a href="">×</a></div>
					<div class="clear"></div>
				</div>--%>

			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="${path}/toMain">继续购物</a></li>
						<li>|</li>
						<li>共<span>${num}</span>件商品，已选择<span>${requestScope.i}</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>${requestScope.total}元</span></div>
					<div class="jsanniu fr"><input class="jsan" type="button" name="jiesuan" onclick="balance()" value="去结算"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			
		</div>

  

	
	<!-- footer -->
	<footer class="center">
			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>

	</body>
</html>
