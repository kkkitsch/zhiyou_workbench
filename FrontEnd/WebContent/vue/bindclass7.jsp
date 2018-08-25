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
<title>v-bind:class</title>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		new Vue({
			el : '#app',
			data : {
				activeColor : 'green',
				fontSize : 30
			}
		});
	});
</script>
</head>
<body>
	<div id="app">

		<!-- 注意：在vue当汇总，不同style之间的分隔符为：, 直接使用DOM元素，不同style之间分隔符为 ： ;-->
		<!-- 我们可以在 v-bind:style 直接设置样式 -->
		<!-- 以下实例相当于：<div style="color: green; font-size: 30px;">菜鸟教程</div> -->
		<div v-bind:style="{ color: activeColor,fontSize: fontSize + 'px' }">菜鸟教程</div>
	</div>
</body>
</html>