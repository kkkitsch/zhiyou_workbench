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
<title>vue 表达式</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* Vue.js 提供了完全的 JavaScript 表达式支持 */
		new Vue({
		  el: '#app',
		  data: {
		    ok: true,
		    message: 'RUNOOB',
		    id : 1
		  }
		});
	});
</script>
</head>
<body>

	<div id="app">
	
		{{5+5}}
		<br> 
		{{ ok ? 'YES' : 'NO' }}
		<br> 
		{{message.split('').reverse().join('') }}
		
		<div v-bind:id="'list-' + id">菜鸟教程</div>
		
	</div>

</body>
</html>