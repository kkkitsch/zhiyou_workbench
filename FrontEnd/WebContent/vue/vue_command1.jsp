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
<title>vue指令1</title>
<style>
	.class1 {
		background: #444;
		color: #eee;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>

	$(function() {
		
		new Vue({
			el : '#app',
			data : {
				class1 : false
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
		<label for="r1">修改颜色</label>
		<!-- 在 input 输入框中我们可以使用 v-model 指令来实现双向数据绑定 -->
		<input type="checkbox" v-model="class1" id="r1" > 
		<br><br>
		<!-- 以下实例判断 class1 的值，如果为 true 使用 class1 类的样式，否则不使用该类 -->
		<div v-bind:class="{'class1': class1}">directiva v-bind:class</div>
	</div>
</body>
</html>