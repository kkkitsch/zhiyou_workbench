<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  request.getParameter("username") 如果用户不填信息的话 获取的值为null值  null值是可以进行==判断的   -->
${msg }
	<form action="user/add" method="post">
		用户：<input type="text" name="username" value="<%= request.getParameter("username")==null ?"":request.getParameter("username") %>"><br>
		邮箱：<input type="text" name="email" value="<%= request.getParameter("email")==null ?"":request.getParameter("email")%>"><br>
		密码：<input type="password" name="password"><br>
		确认密码：<input type="password" name="confirmpwd"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>