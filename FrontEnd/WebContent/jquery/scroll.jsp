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
<title>滚动条</title>

<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	margin: 50px;
}

ul {
	list-style-type: none;
}

li {
	height: 35px;
	line-height: 35px;
}
</style>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		//设置滚动时间间隔为1000ms
		setInterval(function() {
			//将第一条公告克隆
			var newLi = $("ul>:first").clone(true);
			//将克隆的公告放到最后
			$("ul").append(newLi);
			//将第一条公告删除
			$("ul>:first").remove();
		}, 1000);
	});
</script>

</head>
<body>
	<ul>
		<li>这是第1条公告</li>
		<li>这是第2条公告</li>
		<li>这是第3条公告</li>
		<li>这是第4条公告</li>
		<li>这是第5条公告</li>
		<li>这是第6条公告</li>
		<li>这是第7条公告</li>
		<li>这是第8条公告</li>
		<li>这是第9条公告</li>
		<li>这是第10条公告</li>
	</ul>
</body>
</html>