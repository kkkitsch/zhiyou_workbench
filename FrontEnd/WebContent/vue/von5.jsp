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

		/* 点击按钮的不同操作 */
		new Vue({
			el : '#app',
			data : {
				m : 0
			},
			methods : {
				add : function(e) {
					e.stopPropagation();
					this.m += 2;
				},
				add2 : function(m, n) {
					this.m = m + n;
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="app">
		<input type="button" value="单击后增加" @click="m +=1"><input
			type="button" value="绑定函数的按钮" @click="add"> <input
			type="button" value="绑定可传值函数的按钮" @click="add2(3,4)">
		<div>这个按钮被点击了 {{ m }} 。</div>
	</div>
</body>
</html>