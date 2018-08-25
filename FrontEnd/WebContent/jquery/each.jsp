<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery 循环</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		/* 使用jQuery当中的each方法来遍历节点 */
		$("div").each(
				function(index) {
					/* $("div")获取的是类似于节点数组的东西， 而这里的this相当于$("div")获取的当前的节点，相当于一个DOM元素，
						如果要使用jQuery当中的方法，要把DOM对象转换为jQuery对象才行，所以要把this放到$()中，用的是jquery当中的text()f方法*/
					alert("当前的索引地址：" + index + ",使用jQuery中的方法获取文本内容："
							+ $(this).text());
					alert("当前的索引地址：" + index + ",使用DOM对象的属性获取文本内容："
							+ this.innerText);
				})

		/* 使用DOM对象循环 */
		for (var i = 0; i < $("input").length; i++) {
			/* 转换为DOM对象输出 */
			alert("当前的索引地址：" + i + ",文本内容：" + $("input")[i].value);
		}
	});
</script>
</head>
<body>
	<div id="div_01" class="div_01">this is div_01</div>
	<div id="div_02">this is div_02</div>
	<div id="div_03">this is div_03</div>
	<div id="div_04">this is div_04</div>

	<input name="i_01" value="i_01">
	<br>
	<input name="i_02" value="i_02">
	<br>
	<input name="i_03" value="i_03">
	<br>
</body>
</html>