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
<title>vue起步</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		var app = new Vue({
			el : '#app',
			data : {
				message : 'Hello Vue!'
			}
		});

		var app2 = new Vue({
			el : '#app-2',
			data : {
				message : '页面加载于 ' + new Date().toLocaleString()
			}
		});

		var app3 = new Vue({
			el : '#app-3',
			data : {
				seen : true
			}
		});

		var app4 = new Vue({
			el : '#app-4',
			data : {
				todos : [ {
					text : '学习 JavaScript'
				}, {
					text : '学习 Vue'
				}, {
					text : '学学学，学你麻痹'
				} ]
			}
		});

		var app5 = new Vue({
			el : '#app-5',
			data : {
				message : 'Hello Vue.js!'
			},
			methods : {
				reverseMessage : function() {

					/* this.message即为app5.message，是个字符串，indexOf()，toUpperCase()方法都是js当中
						String字符串的方法
					 */
					alert(this.message.indexOf("el"));
					alert(this.message.toUpperCase());

					/* 比较this是否为app5 */
					alert(this == app5);
					alert(this === app5);

					this.message = this.message.split('').reverse().join('');
				}
			}
		});

		var app6 = new Vue({
			el : '#app-6',
			data : {
				message : 'Hello Vue!'
			}
		});

	});
</script>
</head>
<body>
	<div id="app">{{ message }}</div>

	<div id="app-2">
		<!-- 不能使用 app-2.message这种形式访问js中定义的属性-->
		<span v-bind:title="message"> 鼠标悬停几秒钟查看此处动态绑定的提示信息！ </span>
	</div>

	<div id="app-3">
		<p v-if="seen">现在你看到我了</p>
	</div>

	<div id="app-4">
		<ol>
			<li v-for="todo in todos">{{ todo.text }}</li>
		</ol>
	</div>

	<div id="app-5">
		<p>{{ message }}</p>
		<button v-on:click="reverseMessage">逆转消息</button>
	</div>

	<div id="app-6">
		<p>{{ message }}</p>
		<input v-model="message">
	</div>

</body>
</html>