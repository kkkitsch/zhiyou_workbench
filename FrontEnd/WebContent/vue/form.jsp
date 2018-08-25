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
<title>v-bind:class</title>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* v-model 会根据控件类型自动选取正确的方法来更新元素 */
		new Vue({
			el : '#app',
			data : {
				message : 'Runoob',
				message2 : '菜鸟教程\r\nhttp://www.runoob.com'
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
		<p>input 元素：</p>
		<input v-model="message" placeholder="编辑我……">
		<p>消息是: {{ message }}</p>

		<p>textarea 元素：</p>
		<p style="white-space: pre">{{ message2 }}</p>
		<textarea v-model="message2" placeholder="多行文本输入……"></textarea>
	</div>
</body>
</html>