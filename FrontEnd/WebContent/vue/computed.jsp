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

		/* 实例 1 中模板变的很复杂起来，也不容易看懂理解 */
		new Vue({
			el : '#app',
			data : {
				message : 'Runoob!'
			}
		});

		/* 使用了计算属性的实例,让模板变得简单 */

		/*  computed vs methods
			我们可以使用 methods 来替代 computed，效果上两个都是一样的，但是 computed 是
			基于它的依赖缓存，只有相关依赖发生改变时才会重新取值。而使用 methods ，在重新渲染的时
			候，函数总会重新调用执行 
			
			可以说使用 computed 性能会更好，但是如果你不希望缓存，你可以使用 methods 属性
		 */
		var vm = new Vue({
			el : '#app-2',
			data : {
				message : 'Runoob!'
			},
			computed : {
				// 计算属性的 getter
				reversedMessage : function() {
					// this 指向 vm 实例，vm.reversedMessage 依赖于 vm.message，在 vm.message 发生改变时，vm.reversedMessage 也会更新
					return this.message.split('').reverse().join('')
				}
			}
		});

	});
</script>
</head>
<body>

	<div id="app">{{ message.split('').reverse().join('') }}</div>

	<div id="app-2">
		<p>原始字符串: {{ message }}</p>
		<p>计算后反转字符串: {{ reversedMessage }}</p>
	</div>

</body>
</html>