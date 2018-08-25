<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
	success page......
	<br> from request Scope name:${requestScope.name} 
	<br> from request Scope age by map:${requestScope.age} 
	<br> from request Scope email by model:${requestScope.email} 
	<br> from request Scope city by ModelMap:${requestScope.city} 
	<br> from session Scope city from sessionScope:${sessionScope.city} 
	<br> from session Scope name from sessionScope:${sessionScope.name} 
	<br> from request Scope :info=:${requestScope.nice},id=${requestScope.nice.id} 
	<br>
	<a href="testResult">get requestScope.city from result</a>
</body>
</html>