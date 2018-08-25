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
<title>简易计算器</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		//当点击按钮的时候进行加法运算
		$('#button_01').click(function() {
			var num_01 = $("#text_01").val();
			var num_02 = $("#text_02").val();

			//字符串相加的解决办法： * 1
			var result = num_01 * 1 + num_02 * 1;
			$("#text_03").val(result);
		});
	});
</script>
</head>
<body>
	<br> 第一个数：
	<input id="text_01" type="text">
	<br> 第二个数：
	<input id="text_02" type="text">
	<br>
	<input id="button_01" type="button" value="计算">
	<br> 结果：
	<input id="text_03" type="text">
</body>
</html>