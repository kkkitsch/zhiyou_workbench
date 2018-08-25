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
<title>vue起步3</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {
		new Vue({
			el : '#app',
			methods : {
				/* message 为传进来的参数 */
				say : function(message) {
					alert(message);
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="app">

		<!-- 除了直接绑定到一个方法，也可以用内联 JavaScript 语句 -->
		<button v-on:click="say('hi')">Say hi</button>
		<button v-on:click="say('what')">Say what</button>
	</div>
</body>
</html>