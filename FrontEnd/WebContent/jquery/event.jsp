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
<script>
	$(function() {
		$("#button_01").click(function() {

			alert("点击按钮！");
			//第一种让表单提交的方法
			//$("#submit_01").click();
			//第二种让表单提交的方法
			$("#form_01").submit();
		});

		$("#submit_01").click(function() {
			alert("取消执行！");
			//返回值为false，阻止提交按钮的行为
			return false;
		});

	});
</script>
</head>
<body>
	<form id="form_01" action="index.jsp">
		name:<input type="text"> <br> <input id="submit_01"
			type="submit" value="提交"> <br> <input id="button_01"
			type="button" value="自定义提交按钮">
	</form>
</body>
</html>