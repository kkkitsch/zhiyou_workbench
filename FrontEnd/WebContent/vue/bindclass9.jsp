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
				baseStyles : {
					'color' : 'green',
					'fontSize' : '30px'
				},
				overridingStyles : {
					'font-weight' : 'bold'
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="app">

		<!-- v-bind:style 可以使用数组将多个样式对象应用到一个元素上 -->
		<div v-bind:style="[baseStyles,overridingStyles]">菜鸟教程</div>
	</div>
</body>
</html>