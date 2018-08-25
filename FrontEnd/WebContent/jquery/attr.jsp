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
<title>测试使用 attr()</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		/* 获取元素id为img_01,属性为src的属性内容  */
		alert($("#img_01").attr("src"));

		alert("开始切换图片");
		/* 将元素id为img_01,src属性的值替换  */
		$("#img_01").attr("src", "<%=basePath%>static/images/1.jpg");

		alert("将文本框中的值替换");
		/* 将文本框中的值替换  */
		$("#text_01").attr("value", "nnnnnice");

		/*
			val() 和 attr() 的区别:
				
			val()只能获取表单中的value
			attr()可以获取任意属性的值，可以获取任意元素的value，不管这一元素是否可以使用value属性
		 */
		alert($("#a_01").val());
		alert($("#a_01").attr("value"));

		/* 获取复选框中属性checked的值  */
		alert($("#checkbox_01").attr("checked"));
		$("#checkbox_01").attr("checked", false);

		/* removeAttr() 测试： */
		$("img:last").removeAttr("src");
	});
</script>
</head>
<body>
	<br> 图片：
	<img id="img_01" src="<%=basePath%>static/images/2.jpg" height="150"
		width="150">
	<br> 文本框：
	<input id="text_01" type="text" value="default">
	<br> 超链接：
	<a id="a_01" value="a_value">a标签中没有value属性，但是可以使用！</a>
	<br> 复选框：
	<input id="checkbox_01" type="checkbox" checked="checked">
	<br> removeAttr() demo:
	<img src="<%=basePath%>static/images/2.jpg" height="150" width="150" />
</body>
</html>