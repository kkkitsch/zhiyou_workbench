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
.text-danger {
	width: 100px;
	height: 100px;
	background: red;
}

.active {
	width: 100px;
	height: 100px;
	background: green;
}
</style>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		new Vue({
			el : '#app',
			data : {
				isActive : true,
				activeClass : 'active',
				errorClass : 'text-danger'
			}
		});

	});
</script>
</head>
<body>

	<!-- 我们还可以使用三元表达式来切换列表中的 class  -->
	<div id="app">
		<div v-bind:class="[errorClass ,isActive ? activeClass : '']"></div>
	</div>

</body>
</html>