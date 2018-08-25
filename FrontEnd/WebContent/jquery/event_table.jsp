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
		//当焦点在input中时显示span标签
		$("input").focus(function() {
			$("span").show('fast');
		});
		//当焦点离开input中时隐藏span标签
		$("input").blur(function() {
			$("span").hide('slow');
		});
	});
</script>
</head>
<body>
	<input type="text" value="kkk">
	<span style="display: none">this is span</span>
</body>
</html>