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
<title>隔行变色</title>
<style>
#table {
	width: 500px;
	border: 1px solid green;
	border-collapse: collapse;
}

#table td {
	border: 1px solid green;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		//隔行变色,第一种方法
		/* 	$("#table tr:even").css("background", "green");
				$("#table tr:odd").css("background", "yellow"); */
		//隔行变色,第二种方法,使用链式操作
		$("#table tr").filter(":even").css("background", "green").end().filter(
				":odd").css("background", "yellow");
	});
</script>
</head>
<body>
	<table id="table">
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
		<tr>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
			<td>kkk</td>
		</tr>
	</table>
</body>
</html>