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

		/* 单选按钮的双向数据绑定 */
		new Vue({
			el : '#app',
			data : {
				picked : 'Runoob'
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
		<input type="radio" id="runoob" value="Runoob" v-model="picked">
		<label for="runoob">Runoob</label> 
		<br> 
		<input type="radio" id="google" value="Google" v-model="picked"> 
		<label for="google">Google</label> 
		<br> 
		<span>选中值为: {{ picked }}</span>
	</div>
</body>
</html>