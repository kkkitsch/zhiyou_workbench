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
<title>v-show</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* 这里的 seen 参数值和 JavaScript 中的判断一致，为 0、null、undefined、false 时为假，其他值为真 */
		
		/*  v-if 与 v-show 的区别？

			v-if 是动态添加，当值为 false 时，是完全移除该元素，即 dom 树中不存在该元素。
			v-show 仅是隐藏 / 显示，值为 false 时，该元素依旧存在于 dom 树中。若其原有样式设置了 display: none 则会导致其无法正常显示
		*/
		
		new Vue({
			el : '#app',
			data : {
				seen : true
			}
		});

	});
</script>
</head>
<body>

	<div id="app">
		<p v-show="seen">现在你看到我了</p>
	</div>

</body>
</html>