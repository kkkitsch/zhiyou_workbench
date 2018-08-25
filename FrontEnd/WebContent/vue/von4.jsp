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
				say : function(message, e) {
					console.log(message);
					console.log(e.currentTarget);
				}
			}
		});
	});
</script>
</head>
<body>

	<!-- 当绑定 v-on:click 事件时，想传入参数同时也传入当前元素 -->
	<button id="app" v-on:click="say('hi',$event)">say hi</button>
</body>
</html>