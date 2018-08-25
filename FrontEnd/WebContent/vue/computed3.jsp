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
<title>v-for</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		var app = new Vue({
			el : '#app',
			data : {
				name : 'Vue.js'
			},
			// 在 `methods` 对象中定义方法
			computed : {
				name1 : function() {
					alert('222')
				},
				greet : function(event) {
					// `this` 在方法里指当前 Vue 实例
					alert('Hello ' + this.name + '!')
					// `event` 是原生 DOM 事件
					if (event) {
						alert(event.target.tagName)
					}
				}
			}
		});
	});
</script>
</head>
<body>


	<div id="app"></div>

</body>
</html>