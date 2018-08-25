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
<title>使用textarea</title>
<style type="text/css">
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/wangEditor/wangEditor.js"></script>
<script>
	$(function() {
		var E = window.wangEditor;
		var editor = new E('#div1');
		var $text1 = $('#text1');
		editor.customConfig.onchange = function(html) {
			// 监控变化，同步更新到 textarea
			$text1.val(html)
		};
		editor.create();
		// 初始化 textarea 的值
		$text1.val(editor.txt.html());
	});
</script>
</head>
<body>
	<div id="div1">
		<p>
			欢迎使用 <b>wangEditor</b> 富文本编辑器
		</p>
	</div>
	<textarea id="text1" style="width: 100%; height: 200px;"></textarea>
</body>
</html>