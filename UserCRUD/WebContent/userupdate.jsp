<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<!-- disable 属性设置的域无法传到request请求域中   -->
		<input type="hidden" name="id" readonly="readonly" value="${user.id }" ><br>
		用户名：<input type="text" name="username" value="${user.username }"><br>
		邮箱:<input type="text" name="email" value="${user.email }"><br>
		密码:<input type="password" name="password" value="${user.password }"><br>
		<button type="submit">提交</button>
	
	</form>
</body>
</html>