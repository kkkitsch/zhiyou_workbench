<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function changeCode() {
		//得到图片元素
		var img = document.getElementsByTagName("img")[0];
		img.src = "${pageContext.request.contextPath}/validateCode?time="
				+ new Date().getTime();
	}
</script>
</head>
<body>
	${info }
	<br> ${loginInfo }
	<form action="${pageContext.request.contextPath }/login" method="post">
		账号：<input type="text" name="email" placeholder="请输入邮箱"><br>
		密码: <input type="password" name="password" placeholder="请输入密码"><br>
		验证码：<input type="text" name="code" placeholder="${msg }" /> <img
			src="${pageContext.request.contextPath}/validateCode"
			onclick="changeCode()" /><a href="javascript:changeCode()">看不清换一张</a><br>
		<input type="submit" value="登录" /><br>
	</form>


</body>
</html>