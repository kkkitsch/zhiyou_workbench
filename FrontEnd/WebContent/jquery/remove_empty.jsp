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
<title>remove and empty</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/*
		 remove() 和 empty()的区别 ：
		 remove() : 删除整个节点
		 empty()  : 清空节点中的内容
	 */
	$(function() {
		alert("开始删除！");
		$("#div_02").remove();
		alert("开始清空！");
		$("#div_03").empty();
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