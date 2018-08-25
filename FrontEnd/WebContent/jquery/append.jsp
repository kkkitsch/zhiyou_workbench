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
<title>添加数据</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		//内部后置插入
		$("#div_01").append(" world");
		//内部前置插入
		$("#div_01").prepend("hi！tom! ");

		//外部前置插入
		$("#div_01").before("kitsch speak to tom:");
		//外部后置插入
		$("#div_01").after("I am busy!:");

	});
</script>
</head>
<body>
	<div id="div_01">hello</div>
	<br>
	<div id="div_02">hello</div>
	<br>
	<div id="div_03">hello</div>
</body>
</html>