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
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		//全选操作
		$("#all").click(function() {
			$("#checked>:checkbox").each(function() {
				$(this).attr("checked", true);
			});
		});

		//反选操作
		$("#inverse").click(function() {
			$("#checked>:checkbox").each(function() {
				$(this).attr("checked", !$(this).attr("checked"));
			});
		});

		//全部取消操作
		$("#cancle").click(function() {
			$("#checked>:checkbox").each(function() {
				$(this).attr("checked", false);
			});
		});

	});
</script>
</head>
<body>
	<div id="checked">
		兴趣爱好： <br> <input type="checkbox">sports <input
			type="checkbox">musics <input type="checkbox">reading
		<input type="checkbox">sing
	</div>
	<br>
	<input type="button" value="全选" id="all">
	<input type="button" value="反选" id="inverse">
	<input type="button" value="取消" id="cancle">
</body>
</html>