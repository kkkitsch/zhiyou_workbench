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
<title>属性选择器</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		//获取拥有value属性的元素的个数
		alert($("[value]").length);

		//获取class为name的并且拥有value属性的元素的长度
		alert($(".name[value]").length);

		//获取class为name的并且value属性的值为tom的元素的长度
		alert($(".name[value=tom]").length);

		//属性操作，获取原本的值
		alert("属性操作：" + $($(".name")[0]).val());
		//属性操作，将原本的值赋值为：Jackson
		$($(".name")[0]).val("Jackson");
		alert("属性操作：" + $($(".name")[0]).val());

		//测试获取select标签中的值
		alert($("#seop").val());
		//将下拉列表框的值修改为102
		$("#seop").val(2);

	});
</script>
</head>
<body>

	<div>
		<input type="text" class="name" value="kitsch"> <br> <input
			type="text" class="name" value="tom">
	</div>

	<select id="seop">
		<option value="0">请选择班级</option>
		<option value="1">101</option>
		<option value="2">102</option>
	</select>


</body>
</html>