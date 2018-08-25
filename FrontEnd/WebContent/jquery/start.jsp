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
<title>start page</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/* 启动jquery的方式：$=jQuery=window.jQuery
		等效原因：$是jQuery中的一个全局变量，用来表示jQuery这个对象，同时，window可以加载全局变量
		
		启动jQuery的时机：页面中所有的元素都加载完成后，才会执行启动jQuery的代码，
		在$(function(){})这个里面的代码执行时，页面中所有的元素都已经出现了
	 */

	/* 方式一 */
	$(function() {
		alert("启动方式：$(function(){});");
	});

	/* 方式二 */
	jQuery(function() {
		alert("启动方式：jQuery(function(){});");
	});

	/* 方式三 */
	window.jQuery(function() {
		alert("启动方式：window.jQuery(function(){});");
	});

	/* 方式四 */
	$(document).ready(function() {
		alert("启动方式：$(document).ready(function() {})");
	});
</script>

</head>
<body>
	<h3>jQuery start</h3>
</body>
</html>