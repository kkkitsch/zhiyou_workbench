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

		var vm = new Vue({
			el : '#app',
			data : {
				name : 'Google',
				url : 'http://www.google.com'
			},
			computed : {
				site : {
					// getter
					get : function() {
						return this.name + ' ' + this.url
					},
					// setter，newValue即为：菜鸟教程 http://www.runoob.com
					set : function(newValue) {
						/* 拆分后卫一个数组 */
						var names = newValue.split(' ')
						this.name = names[0]
						this.url = names[names.length - 1]
					}
				}
			}
		});

		/* 调用set方法 */
		vm.site = '菜鸟教程 http://www.runoob.com';
		console.log('name: ' + vm.name);
		console.log('url: ' + vm.url);

	});
</script>
</head>
<body>


	<div id="app">
		<p>{{ site }}</p>
	</div>

</body>
</html>