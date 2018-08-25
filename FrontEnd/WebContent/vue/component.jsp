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
<title>vue 组件使用demo</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* 注册一个全局组件，所有实例都能使用全局组件 */
		Vue.component('runoob', {
			template : '<h3>自定义组件!</h3>'
		});

		/* 创建一个实例 */
		new Vue({
			el : '#app'
		});

	});
</script>
</head>
<body>
	<div id="app">
		<runoob></runoob>
	</div>
</body>
</html>