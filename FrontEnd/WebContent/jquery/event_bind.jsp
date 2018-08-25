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
		//绑定click()方法并执行function()
		$("#a_01").bind("click", function() {
			//$(this) : 表示出发当前事件的jQuery对象，获取jQuery对象href属性的值
			var v_href = $(this).attr("href");
			if (v_href == "index.jsp") {
				return false;
			} else {
				//阻止浏览器的默认行为以及事件的气泡
				return true;
			}
		});
	});
</script>
</head>
<body>
	<a id="a_01" href="<%=basePath%>index.jsp">跳转到index.jsp</a>
</body>
</html>