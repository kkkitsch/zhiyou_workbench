<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.hide {
	display: none;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		//可见性选择器
		//输出不可见选择器
		alert($("div:hidden").text())
		//输出可见选择器
		alert($("div:visible").text())
		//输出input中不能修改的值,两种方法
		alert($("input:disabled").val());
		alert($("input[disabled=disabled]").val());
		//输出input中能修改的值
		alert($("input:enabled").val());
		//输出复选框中勾选的值
		alert($("input:checked").val())
		alert($("input[checked=checked]").val())
		alert($(":checked").val())
		//输出下拉框中选中的值
		alert("输出下拉框中选中的值:" + $(":selected").val());
		alert("输出下拉框中选中的值:" + $("select option:selected").val());
		alert("输出下拉框中选中的值:" + $("select option[selected=selected]").val()); 
		//each输出多个
		var selected = $("select option[selected=selected]");
		selected.each(function() {
			var obj = $(this);
			alert(obj.val());
		});
	});
</script>
</head>
<body>
	<p>p1</p>
	<p>p2</p>
	<div>可见div</div>
	<div class="hide">不可见div</div>
	<br>
	<input type="text" value="不能修改的文本" disabled="disabled" />
	<br>
	<input type="text" value="能修改的文本" />
	<br>
	<input type="checkbox" checked="checked" value="aaa" />
	<br>
	<input type="checkbox" value="aaa" />
	<br>
	<input type="checkbox" value="aaa" />
	<br>
	<select>
		<option value="1" selected="selected">kkk</option>
		<option value="2" selected="selected">bbb</option>
		<option value="3" selected="selected">aaa</option>
	</select>
</body>
</html>