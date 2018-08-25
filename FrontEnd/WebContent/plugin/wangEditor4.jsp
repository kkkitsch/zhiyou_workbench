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
<title>参数配置,菜单栏的配置</title>
<style type="text/css">
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/wangEditor/wangEditor.js"></script>
<script>
	$(function() {

		var E = window.wangEditor;
		var editor = new E('#div1');
		editor.customConfig.onchangeTimeout = 1000;
		editor.customConfig.onchange = function(html) {
			// html 即变化之后的内容
			console.log(html);
		};
		editor.create();

		document.getElementById('btn1').addEventListener('click', function() {
			// 如果未配置 editor.customConfig.onchange，则 editor.change 为 undefined
			editor.change && editor.change();
		});

	});
</script>
</head>
<body>
	<div id="div1">
		<p>欢迎使用 wangEditor 富文本编辑器</p>
	</div>

	<p>手动触发 onchange 函数执行</p>
	<button id="btn1">change</button>
</body>
</html>