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
<title>v-if demo</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		new Vue({
			el : '#app',
			data : {
				seen : true,
				ok : false,
				okder:false,
				something:false
			}
		});

	});
</script>
</head>
<body>

	<div id="app">
	
		<!-- v-if 指令将根据表达式 seen 的值(true 或 false )来决定是否插入 p 元素 -->
		<p v-if="seen">现在你看到我了</p>

		<!-- 
			v-else-if 在 2.1.0 新增，顾名思义，用作 v-if 的 else-if 块。可以链式的多次使用
			v-else 、v-else-if 必须跟在 v-if 或者 v-else-if之后
		 -->
		<template v-if="ok">
			<h1>菜鸟教程</h1>
			<p>学的不仅是技术，更是梦想！</p>
			<p>哈哈哈，打字辛苦啊！！！</p>
		</template>
		
		<template v-else-if="okder">
			<h1>我爱洗澡 皮肤好好</h1>
		</template>
		
		<template v-else-if="something">
			<h1>啦啦啦</h1>
		</template>
		
		<template v-else="seen">
			<h1>you see me</h1>
		</template>

	</div>

</body>
</html>