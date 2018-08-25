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

<!-- 找到本地的css样式 -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/datetimepicker/jquery.datetimepicker.css" />

<!-- 本地jQuery库 -->
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>

<!-- 本地datetimepicker.full.js，不是datetimepicker.js文件，注意区别 -->
<script
	src="<%=basePath%>static/datetimepicker/jquery.datetimepicker.full.js"></script>

<script>
	$(function() {
		//获得日期
		var date = $('#start').datetimepicker();
		var date = $('#end').datetimepicker();
		//输出获得的日期
		//alert(date.val());
	});
</script>

</head>
<body>
	开始时间：
	<input id="start" type="text">
	<br> 结束时间：
	<input id="end" type="text">

</body>
</html>