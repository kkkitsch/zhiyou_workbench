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
<title>vue起步2</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* 定义一个Vue对象 */
		var data = {
			site : "菜鸟教程",
			url : "www.runoob.com",
			alexa : 10000
		};

		/* 定义一个Vue实例，并获取对象的全部属性 */
		var vm = new Vue({
			el : '#vue_det',
			data : data
		});

		/* 对象和实例引用相同的对象 */
		console.log(data.site == vm.site);
		console.log(data.site === vm.site);

		/* 设置属性也会影响到原始数据 */
		vm.site = "Runoob";
		console.log(data.site);
		data.alexa = 12345;
		console.log(vm.alexa);

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