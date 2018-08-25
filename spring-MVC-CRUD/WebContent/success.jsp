<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUCCESS</title>

<!-- 
导入js库 

加载静态资源方式：
<mvc:default-servlet-handler />
<mvc:annotation-driven></mvc:annotation-driven>
-->
<script type="text/javascript" src="js/jquery.js"></script>

<!--  
当点击第一个超链接时，会执行此方法，将超链接中href中的地址复制到form表单中action属性当中，并且提交
return false ：点击超链接时，不执行
-->
<script>
	$(function() {
		$('a:first').click(function() {
			$('form').attr('action', $('a:first').attr('href')).submit();
			return false;
		});
	});
</script>

</head>
<body>
	<!--  
	如果不存在，应该展示一个信息
	如果存在，应该将所有的员工 通过表格方式显示
	JSTL:简单的标签 ，代替复杂的操作
	-->
	<br>
	<c:if test="${empty requestScope.emps}">
		<h3 align="center">no employee</h3>
	</c:if>
	<c:if test="${!empty requestScope.emps}">
		<h3 align="center">THE EMPLOYEE LIST</h3>
		<table align="center" border="1" width="2">
			<tr align="center">
				<td>ID</td>
				<td>NAME</td>
				<td>MAIL</td>
				<td>GENDER</td>
				<td>DEPARTMENT</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
			<c:forEach items="${requestScope.emps}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.mail}</td>
					<td>${emp.gender==0?'MALE':'FAMALE'}</td>
					<td>${emp.dept.depName}</td>
					<td><a href="emp/${emp.id}">DELETE</a></td>
					<td><a href="input/${emp.id}">UPDATE</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


	<!-- 将GET 请求转化为POST请求 -->
	<form action="" method="post">
		<input type="hidden" name="_method" value="delete">
	</form>


</body>
</html>