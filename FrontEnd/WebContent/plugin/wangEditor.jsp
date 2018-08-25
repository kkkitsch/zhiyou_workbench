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
<title>富文本编辑器使用示例</title>
<style type="text/css">
.toolbar {
	border: 1px solid #ccc;
}

.text {
	border: 1px solid #ccc;
	height: 400px;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/wangEditor/wangEditor.js"></script>
<script>
	$(function() {

		/* 如何使用wangEdotor */
		var E = window.wangEditor;
		var editor1 = new E('#div1', '#div2'); // 两个参数也可以传入 elem 对象，class 选择器
		editor1.create();

		/* 向文本编辑器中设置内容 */
		editor1.txt.html('<p>用 JS 设置的内容</p>');

		/* 追加内容 */
		editor1.txt.append('<p>追加的内容</p>');

		/* 清空编辑器中的内容 */
		editor1.txt.clear();

		/* 再次向文本编辑器中设置内容 */
		editor1.txt.html('<p>用 JS 再次设置的内容</p>');

		/* 再次向文本编辑器中追加内容 */
		editor1.txt.append('<p>再次追加的内容</p>');

		/* 获取富文本编辑框中的内容，包含节点 */
		document.getElementById('btn1').addEventListener('click', function() {
			// 读取 html
			alert(editor1.txt.html())
		}, false)

		/* 获取富文本编辑框中的内容，只含有文字 */
		document.getElementById('btn2').addEventListener('click', function() {
			// 读取 text
			alert(editor1.txt.text())
		}, false)

	});
</script>
</head>
<body>
	<!-- 使菜单栏和文本框分离 -->
	<div id="div1" class="toolbar"></div>

	<!-- 菜单栏和文本框的中间隔离带 -->
	<div style="padding: 5px 0; color: #ccc">中间隔离带</div>

	<!-- 富文本编辑框 -->
	<div id="div2" class="text">
		<!--可使用 min-height 实现编辑区域自动增加高度-->
		<p>欢迎使用 wangEditor 编辑器</p>
	</div>

	<button id="btn1">获取html</button>
	<button id="btn2">获取text</button>

</body>
</html>