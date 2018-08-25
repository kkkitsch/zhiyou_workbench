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
<title>代码的执行顺序</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/*
	 html是解释性语言，从上往下执行，当执行	document.getElementById("name").value时， 找不到id为name的元素，就不执行了，导致下面所有的代码都不执行了
	 */
	alert(document.getElementById("name").value);
	alert("执行这个代码");
</script>
</head>
<body>
	name:
	<input id="name" name="name" value="default">
</body>
</html>