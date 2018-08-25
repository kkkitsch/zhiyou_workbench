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
<title>vue 监听</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {
		var vm = new Vue({
			el : '#computed_props',
			data : {
				kilometers : 0,
				meters : 0
			},
			methods : {},
			computed : {},
			watch : {
				kilometers : function(val) {
					this.kilometers = val;
					this.meters = val * 1000;
				},
				meters : function(val) {
					this.kilometers = val / 1000;
					this.meters = val;
				}
			}
		});
		// $watch 是一个实例方法,这个回调将在 vm.kilometers 改变后调用
		vm.$watch('kilometers', function(newValue, oldValue) {
			document.getElementById("info").innerHTML = "修改前值为: " + oldValue
					+ "，修改后值为: " + newValue;
		});
	});
</script>
</head>
<body>
	<div id="computed_props">
		千米 : <input type="text" v-model="kilometers"> 
		<br>
		米 : <input type="text" v-model="meters">
	</div>

	<p id="info"></p>
</body>
</html>