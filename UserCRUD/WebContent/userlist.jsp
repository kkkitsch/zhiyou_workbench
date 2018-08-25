<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${!empty pageUser.userList }">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<th>用户ID</th>
						<th>用户姓名</th>
						<th>用户邮箱</th>
						<th colspan="2">编辑</th>
					</tr>
					
					<c:forEach items="${pageUser.userList }" var="user" >
						<tr>
							<td>${user.id }</td>
							<td>${user.username }</td>
							<td>${user.email }</td>
							<td>
							<a href="${pageContext.request.contextPath }/user/preUpdate?id=${user.id}">
								修改
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/user/delete?id=${user.id}">	
									删除
								</a>
							 </td>
						</tr>
					</c:forEach>
				</table>
				<a href="${pageContext.request.contextPath }/page?currentPage=${pageUser.currentPage==1 ? 1:pageUser.currentPage-1}">上一页<< </a>
					当前页${pageUser.currentPage }/共${pageUser.totalPage }页
				<a href="${pageContext.request.contextPath }/page?currentPage=${pageUser.currentPage == pageUser.totalPage ? pageUser.totalPage : pageUser.currentPage+1}"> >>下一页</a>
		</c:when>
		<c:when test="${empty userlist }">
			没有用户信息  
			<a href="index.jsp">返回首页</a>
		</c:when>
	</c:choose>
	
	
</body>
</html>