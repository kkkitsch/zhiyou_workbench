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
				classObject : {
					'active' : true,
					'text-danger' : true
				}
			}
		});

	});
</script>
</head>
<body>

	<!-- 我们也可以直接绑定数据里的一个对象 -->
	<div id="app">
		<div v-bind:class="classObject"></div>
	</div>

</body>
</html>