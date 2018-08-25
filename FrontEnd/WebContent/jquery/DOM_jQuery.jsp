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
<title>jQuery对象和DOM对象的转换</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		alert("获取class为name的节点的长度：" + $(".name").length);
		alert("通过DOM对象输出值：" + $(".name")[0].value);
		alert("通过jQuery对象输出值：：" + $(".name").val());
		alert("将jQuery对象转换为DOM对象，再将DOM对象转换为jQuery对象输出："
				+ $($(".name")[0]).val());

		alert("通过ID获取DOM对象，并得到value："
				+ document.getElementById("username").value);
		alert("将得到的DOM对象转换为jQuery对象，并输出value："
				+ $(document.getElementById("username")).val());

	});
</script>
</head>
<body>
	<br> name:
	<input class="name" name="name" value="kitsch">
	<br> 姓名：
	<input class="name" name="name" value="刻奇">
	<br> kkk:
	<input id="username" type="text" name="username" value="kkk">
</body>
</html>