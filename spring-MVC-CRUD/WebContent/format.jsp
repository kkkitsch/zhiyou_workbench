<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>format test</title>
</head>
<body>
	<form:form action="testFormat" modelAttribute="user">

		<form:errors path="*" />
		<br>
		NAME:<form:input path="name" />
		<br> 
		AGE:<form:input path="age" />
		<br> 
		SALARY:<form:input path="salary" />（输入格式：#.###.##）
		<br>
		BIRTH:<form:input path="birth" />（输入格式：yyyy-MM-dd）
		<br>
		EMAIL:<form:input path="email" />
		<br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>