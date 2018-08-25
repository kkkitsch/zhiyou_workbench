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
			el : "#app",
			data : {
				isActive : true,
				hasError : true
			}
		});

	});
</script>
</head>
<body>

	<div id="app">

		<!-- 我们也可以在对象中传入更多属性用来动态切换多个 class -->
		<!-- 验证发现，绑定class时，第一个class active加不加引号都无所谓，以后的class都要加引号，而且引号必须为单引号 -->
		<div class="static"
			v-bind:class="{ 'active': isActive, 'text-danger': hasError }"></div>
	</div>

</body>
</html>