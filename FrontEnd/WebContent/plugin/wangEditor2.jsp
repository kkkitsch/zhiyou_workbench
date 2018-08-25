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
<title>获取JSON</title>
<style type="text/css">
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/wangEditor/wangEditor.js"></script>
<script>
	$(function() {
		/* 开始使用富文本编辑器 */
		var E = window.wangEditor;
		var editor = new E('#div1');
		editor.create();

		/* 给img添加监听事件，获取 JSON 格式的内容 */
		document.getElementById('btn1').addEventListener('click', function() {

			/* 获取 JSON 格式的内容 */
			var json = editor.txt.getJSON(); // 

			/* 控制台输出 */
			console.log("获取json数据值:");
			console.log(json);
			console.log("获取json数据值属性:" + json[0].attrs.length);
			console.log("获取json数据值属性:" + json[0].tag);

		});
	});
</script>
</head>
<body>
	<div id="div1">
		<p>
			欢迎使用 <b>wangEditor</b> 富文本编辑器
		</p>
		<img
			src="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png"
			style="max-width: 100%;" />
	</div>
	<button id="btn1">getJSON</button>
</body>
</html>