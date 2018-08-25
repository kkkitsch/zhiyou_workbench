<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>text html compare</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		/*
			html() : 获取元素的内容，包括html代码
			text() : 获取元素的内容，不包括html代码
		 */
		alert($("#div_01").html());
		alert($("#div_01").text());

		alert($("#div_02").html());
		alert($("#div_02").text());

		/* 将代码放到id为div_03的标签中 */
		$("#div_03").html("<p>this is p</p>");
		/* 将文本放到id为div_04的标签中 */
		$("#div_04").text("<p>this is p</p>");
	});
</script>
</head>
<body>
	<div id="div_01">你好，世界！</div>
	<br>
	<div id="div_02">
		<a href="#">你好，世界！</a>
	</div>
	<br>
	<div id="div_03"></div>
	<div id="div_04"></div>
</body>
</html>