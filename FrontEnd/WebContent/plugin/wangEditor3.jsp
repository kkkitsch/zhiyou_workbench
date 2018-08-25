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
		// 自定义菜单配置
		editor.customConfig.menus = [ 'head', 'bold', 'italic', 'underline' ];
		editor.create();
	});
</script>
</head>
<body>
	<div id="div1">
		<p>欢迎使用 wangEditor 富文本编辑器</p>
	</div>
</body>
</html>