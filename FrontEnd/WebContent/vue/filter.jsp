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
			data : {
				message : 'runoob'
			},
			filters : {
				capitalize : function(value) {
					if (!value) {
						return '';
					}
					value = value.toString();
					return value.charAt(0).toUpperCase() + value.slice(1)
							+ "----------kkkkkkkkk";
				},
				capitalize1 : function(value, arg1, arg2) {
					if (!value) {
						return '';
					}
					value = value.toString();
					return value.charAt(0).toLowerCase() + value.slice(1)
							+ "----------" + arg1 + "----------" + arg2;
				}
			}
		});

	});
</script>
</head>
<body>

	<!-- Vue.js 允许你自定义过滤器，被用作一些常见的文本格式化。由"管道符"指示 -->
	<!-- 过滤器函数接受表达式的值作为第一个参数 -->
	<!-- <div id="app">{{ message | capitalize }}</div> -->




	<!-- 
		过滤器可以串联，并且可以传递参数
	
		在这个例子中，capitalize 被定义为接收单个参数的过滤器函数，表达式 message 
		的值将作为参数传入到过滤器函数capitalize中。然后继续调用同样被定义为接收单个
		参数的过滤器函数 capitalize1，将 capitalize 的结果传递到 capitalize1 中
		的第一个参数 value当中,在过滤器capitalize1中还定义了另外两个参数，作为arg1
		和arg2的调用，同时，在div节点中定义的过滤器，不能分割在两行，否则会报错
	 -->
	<div id="app">{{ message | capitalize | capitalize1("this is first arg1","this is second arg2") }}</div>

</body>
</html>