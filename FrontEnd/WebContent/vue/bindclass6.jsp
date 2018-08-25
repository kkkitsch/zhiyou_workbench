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

<style>
.active {
	width: 100px;
	height: 100px;
	background: green;
}

.text-danger {
	background: red;
}
</style>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		new Vue({
			el : '#app',
			data : {
				activeClass : 'active',
				errorClass : 'text-danger'
			}
		});
	});
</script>
</head>
<body>
	<div id="app">

		<!-- 我们可以把一个数组传给 v-bind:class ，相当于：<div class="active text-danger"></div> -->
		<div v-bind:class="[activeClass, errorClass]"></div>
	</div>

</body>
</html>