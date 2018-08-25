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
<title>jquery 选择器</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function(){
		
		/* 元素选择器、hidden选择器的使用 ，中间不用加空格*/
		alert($("input:hidden").attr("name"));
	});
</script>
</head>
<body>
	<form>
		<input type="text" name="email" />
		<input type="hidden" name="id" />
	</form>
</body>
</html>