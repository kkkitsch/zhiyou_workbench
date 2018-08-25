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

		/* 下拉列表的双向数据绑定 */
		new Vue({
			el : '#app',
			data : {
				selected : ''
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
		<select v-model="selected" name="fruit">
			<option value="">选择一个网站</option>
			<option value="www.runoob.com">Runoob</option>
			<option value="www.google.com">Google</option>
		</select>

		<div id="output">选择的网站是: {{selected}}</div>
	</div>
</body>
</html>