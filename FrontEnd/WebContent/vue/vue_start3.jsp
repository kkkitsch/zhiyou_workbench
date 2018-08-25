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
<title>vue起步3</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* 数据对象 */
		var data = {
			site : "菜鸟教程",
			url : "www.runoob.com",
			alexa : 10000
		};

		/* 实例 */
		var vm = new Vue({
			el : '#vue_det',
			data : data
		});

		/* Vue 实例还提供了一些有用的实例属性与方法。它们都有前缀 $，以便与用户定义的属性区分开来 */
		console.log(vm.$data == data);
		console.log(vm.$data === data);

		console.log(vm.$el == document.getElementById("vue_det"));
		console.log(vm.$el === document.getElementById("vue_det"));

	});
</script>
</head>
<body>

	<div id="vue_det">
		<h1>site : {{site}}</h1>
		<h1>url : {{url}}</h1>
		<h1>Alexa : {{alexa}}</h1>
	</div>

</body>
</html>