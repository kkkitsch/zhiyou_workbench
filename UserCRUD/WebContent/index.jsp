<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	欢迎:${userName }<br>
	<!-- 类似 RESTFul（表述性状态资源转移 ）风格的API   可以根据请求的地址信息 以及请求的方式 进行资源的处理  -->
<a href="${pageContext.request.contextPath }/user/list">查看所有的用户</a> <br>
<a href="${pageContext.request.contextPath }/useradd.jsp">添加用户</a>

</body>
</html>