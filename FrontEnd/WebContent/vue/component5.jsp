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

		/* 将 v-bind 指令将 todo 传到每一个重复的组件中 */
		Vue.component('todo-item', {

			/* prop 是父组件用来传递数据的一个自定义属性 */
			/* 同样也可以在 vm 实例中像 "this.message" 这样使用 */
			props : [ 'todo' ],
			template : '<li>{{ todo.text }}</li>'
		});

		// 创建根实例
		new Vue({
			el : '#app',
			data : {
				sites : [ {
					text : 'Runoob'
				}, {
					text : 'Google'
				}, {
					text : 'Taobao'
				} ]
			}
		});

	});
</script>
</head>
<body>

	<div id="app">
		<ol>
			<todo-item v-for="item in sites" v-bind:todo="item"></todo-item>
		</ol>
	</div>

</body>
</html>