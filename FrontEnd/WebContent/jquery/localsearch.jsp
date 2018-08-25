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
<style type="text/css">
table {
	border: 1px solid #abcdef;
	width: 360px;
	border-collapse: collapse;/* 表格的边框是否被合并成一个单一的边框 */
}

tr, td {
	border: 1px solid #abcdef;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	//一个本地化搜索
	$(function() {
		$('#search').click(
			function() {
				var contains = $("input[type=text]").val();
				$('table tr:not("#thead")').hide().filter(
						':contains("' + contains + '")').show();
			});
	});
</script>

</head>
<body>
	<table>
		<tr id="thead">
			<td>姓名</td>
			<td>性别</td>
			<td>手机号</td>
		</tr>
		<tr>
			<td>tony</td>
			<td>男</td>
			<td>18636261278</td>
		</tr>
		<tr>
			<td>alice</td>
			<td>女</td>
			<td>13837991772</td>
		</tr>
		<tr>
			<td>William</td>
			<td>男</td>
			<td>17027822621</td>
		</tr>
		<tr>
			<td>Steve</td>
			<td>男</td>
			<td>13532467858</td>
		</tr>
		<tr>
			<td>kangkang</td>
			<td>男</td>
			<td>17652417292</td>
		</tr>
		<tr>
			<td>Maria</td>
			<td>女</td>
			<td>18683702816</td>
		</tr>
	</table>
	<input type="text">
	<br>
	<button id="search">搜索</button>

</body>