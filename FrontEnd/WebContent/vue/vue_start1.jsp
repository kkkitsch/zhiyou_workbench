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
<title>vue起步1</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {
		var vm = new Vue({
			el : '#vue_det',
			data : {
				site : "菜鸟教程",
				url : "www.runoob.com",
				alexa : "10000"
			},
			methods : {
				details : function() {
					return this.site + "---学的不仅仅是技术，更是梦想！";
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="vue_det">
		<h3>站点：{{site+1+"1"+(1+1)+((1+1)>2)}}</h3>
		<h3>网址：{{url}}</h3>
		<h3>排名：{{alexa}}</h3>
		<h3>签名：{{details()}}</h3>
	</div>
</body>
</html>