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
<title>addClass and removeClass</title>
<style type="text/css">
.div_01 {
	background-color: green;
}

.div_02 {
	background-color: gray;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		alert("添加一个class到div_02");
		$("#div_02").addClass("div_02");

		alert("移除一个class");
		$("#div_02").removeClass("div_02");

	});
</script>
</head>
<body>
	<div id="div_01" class="div_01">this is div_01</div>
	<div id="div_02">this is div_02</div>
</body>
</html>