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
<title>双向数据绑定</title>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		new Vue({
			el : '#app',
			data : {
				selected : ''
			}
		});
		
		new Vue({
			el : '#app-1',
			data : {
				age : ''
			}
		});
		
		new Vue({
			el : '#app-2',
			data : {
				message : ''
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
	
		<!-- 如果要自动过滤用户输入的首尾空格，可以添加 trim 修饰符到 v-model 上过滤输入 -->
		<input type="text" v-model.trim="selected">
		<br>
		<span>输入的值为：{{selected}}</span>
	</div>
	
	<hr>
	
	<!-- 如果想自动将用户的输入值转为 Number 类型（如果原值的转换结果为 NaN 则返回原值），可以添加一个修饰符 number 给 v-model 来处理输入值 -->
	<div  id="app-1">
		<input v-model.number="age" type="number">
		<br>
		<span>输入的值为：{{age}}</span>
	</div>
	
	<hr>
	
	<!-- 在默认情况下， v-model 在 input 事件中同步输入框的值与数据，但你可以添加一个修饰符 lazy ，从而转变为在 change 事件中同步 -->
	<div  id="app-2">
		<input type="text" v-model.lazy="message" >
		<br>
		<span>输入的值为：{{message}}</span>
	</div>
	
	
</body>
</html>