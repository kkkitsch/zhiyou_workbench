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

		/* 自定义组件 */
		var Child = {
			template : '<h3>自定义组件!</h3>'
		};

		/* 在实例中注册一个局部组件 */
		new Vue({
			el : '#app',
			components : {
				/* <runoob> 将只在父模板可用 */
				'runoob' : Child
			}
		});

	});
</script>
</head>
<body>

	<div id="app">
		<runoob></runoob>
	</div>

</body>
</html>