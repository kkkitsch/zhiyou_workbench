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

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/jqzoom/jquery.jqzoom.js"></script>
<link rel="stylesheet" href="<%=basePath%>static/jqzoom/jqzoom.css"
	type="text/css" media="screen" />
<script>
	$(function() {
		$(".jqzoom").jqueryzoom({
			xzoom : 100, //zooming div default width(default width value is 200)
			yzoom : 100, //zooming div default width(default height value is 200)
			offset : 10, //zooming div default offset(default offset value is 10)
			position : "right" //zooming div position(default position value is "right")
		});
	});
</script>
</head>
<body>
	<div class="jqzoom">
		<!-- jqimg:放大显示的图片 -->
		<img src="<%=basePath%>static/images/1.jpg" alt="scarpa"
			jqimg="<%=basePath%>static/images/1.jpg">
	</div>
</body>
</html>