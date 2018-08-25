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
<title>Id selector</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		/* 测试id选择器  ，结果为 1*/
		alert("长度：" + $("#name").length);

		/* 如果id重复了，那么jQuery会获取第一次出现的这个id作为jQuery对象 */
		alert("jquery 对象 name的值：" + $("#name").val())

		/* 通过id选择器将jQuery对象转换为DOM对象并输出值 */
		var v_dom = $("#name")[0];
		alert("DOM对象 name的值：" + v_dom.value);

	});
</script>
</head>
<body>
	name:
	<input id="name" name="name" value="kitsch">
	<br> 姓名：
	<input id="name" name="name" value="刻奇">
</body>
</html>