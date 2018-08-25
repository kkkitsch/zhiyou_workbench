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
		$("#button").bind("click", function() {
			$.ajax({
				type : "post", //请求类型
				url : "<%=basePath%>checkName", //请求地址
				data : "loginName=" + $("#loginName").val(), //向请求发送的参数
				dataType : "json", //返回结果类型
				success : function(data) { //请求成功后的回调函数
					if (!data) {
						$("#message").text("id已被使用");
						$("#message").attr("color", "red");
					} else {
						$("#message").text("id使用成功");
						$("#message").attr("color", "green");
					}
				},
				error : function() {//出现错误时执行
					$("#errorMessage").text("服务器内部出现错误，请稍候重试");
					$("#errorMessage").attr("color", "red");
				}
			});
		});
	});
</script>
</head>
<body>
	<h3 id="errorMessage" align="center"></h3>
	<br> 账号：
	<input id="loginName" type="text" name="loginName">
	<span><font id="message"></font></span>
	<br>
	<input id="button" type="button" value="submit">
</body>
</html>