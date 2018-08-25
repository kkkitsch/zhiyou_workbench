<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--  
	使用jQuery插件bxSlider完成图片的滚动
	首先是加载jQuery库，以及bxSlider插件文件和相关CSS文件，您可以从官方网站下载最新版本的bxSlider
-->
<style type="text/css">
img {
	width: 300px;
	height:320px;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/bxslider/jquery.bxslider.css">
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/bxslider/jquery.bxslider.js"></script>
<script>
	$(function() {
		$(".bxslider").bxSlider({
			'speed' : 500, //内容切换速度，数字，ms
			'auto' : true, //设置是否自动滑动
			'pause' : 2000, //自动滑动时停留时间，数字，ms
			'mode' : 'horizontal', //设置滑动模式，'horizontal':水平, 'vertical':垂直, 'fade':淡入淡出
			'autoHover' : true,//	当鼠标滑向滑动内容上时，是否暂停滑动
			'controls' : true,
		});
	});
</script>
</head>
<body>
	<ul class="bxslider">
		<li><img src="<%=basePath%>static/images/1.jpg" /></li>
		<li><img src="<%=basePath%>static/images/2.jpg" /></li>
		<li><img src="<%=basePath%>static/images/3.jpg" /></li>
		<li><img src="<%=basePath%>static/images/4.jpg" /></li>
		<li><img src="<%=basePath%>static/images/5.jpg" /></li>
	</ul>
</body>
</html>