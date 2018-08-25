<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>input test</title>
</head>
<body>
	<%-- 
	
	
	首先你得先明白回显是什么意思
	
	
	引入form表单标签库
	常用标签：
	
		1、<form:form>:可以完成回显的操作，modelAttribute：完成回显，自动地到 请求范围中，寻找指定key
		  	对应的value值，如果没有指定modelAttribute属性，springMVC自动地在请求范围中找一个叫
			command这样的key对象，如果command也没有，会报错
			
		2、<form:input>:文本框，path：name的属性值，提交后输入的值会回显。
		3、<form:radiobuttons path="" items="" />:便利的集合，如果是
			map类型，map当中key作为每一个单选按钮的value值，map里 的value，对
			应单选按钮的显示内容 
		4、<form:select path="dept.depName"
						items="${requestScope.depts}" itemLabel="depName"
						itemValue="depId"></form:select>
			
			
		5、以下path属性对应的值应和Employee类对应的属性一致
		
		6、<form:select></form:select>标签中的属性：itemLabel="" itemValue=""是items的子属性，属性值参考items的属性
			
			--%>


	<h3>${abc.id != null ? 'UPDATE EMPLOYEE' : 'ADD EMPLOYEE' }</h3>

	<!--  
	action的值当中应有：   ../
	原因：不加上../会跳转到：http://localhost:8080/spring-MVC-CRUD/input/emp
		原本是想跳转到：http://localhost:8080/spring-MVC-CRUD/emp
	-->
	<form:form action="../emp" method="post" modelAttribute="abc">


		<!-- 
		这个页面要完成两个功能，雇员的增加和修改，使用REST风格有两种不同的提交方式：POST、PUT，
		当增加雇员的时候，使用POST请求，当修改雇员的时候使用PUT请求
		所以，必须使用隐藏表单域来完成请求方式的修改
		
		先使用EL表达式判断传进来的回显数据id是否为null，来判断是增加雇员还是修改 雇员 
		-->
		<c:if test="${abc.id !=null }">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id" />
		</c:if>

		<table>
			<tr>
				<td>NAME</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="mail" /></td>
			</tr>

			<!-- 
			实现功能：只有新建雇员的时候才显示gender属性，当修改操作的时候，不显示gender属性 
			那么问题来了：修改操作的时候，没有gender属性，返回的是一个null，怎么办？
			-->
			<c:if test="${abc.id == null}">
				<tr>
					<td>GENDER</td>
					<td><form:radiobuttons path="gender"
							items="${requestScope.genders}" /></td>
				</tr>
			</c:if>


			<tr>
				<td>DEPARTMENT</td>
				<td><form:select path="dept.depId"
						items="${requestScope.depts}" itemLabel="depName"
						itemValue="depId"></form:select></td>
			</tr>
			<tr>
				<input type="submit" value="${abc.id != null ? 'UPDATE' : 'ADD' }">
			</tr>
		</table>
	</form:form>

</body>
</html>