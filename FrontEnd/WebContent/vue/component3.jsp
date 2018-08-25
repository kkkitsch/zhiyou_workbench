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

		// 注册
		Vue.component('child', {
			// 声明 props
			props : [ 'message' ],
			// 同样也可以在 vm 实例中像 “this.message” 这样使用
			template : '<span>{{ message }}</span>'
		});

		/* 创建根实例 */
		new Vue({
			el : '#app'
		});

	});
</script>
</head>
<body>

	<div id="app">
		<child message="hello!"></child>
	</div>

</body>
</html>