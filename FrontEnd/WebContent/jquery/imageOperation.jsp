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
<title>Insert title here</title>

<style type="text/css">

/*
	样式表会覆盖，后出现的样式会覆盖先出现的样式
*/
.img {
	width: 80px;
	height: 80px;
	border-color: fuchsia;
	border-style: solid;
}

.img_01 {
	border-color: green;
	border-style: solid;
}
</style>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/*
		使用纯正的jQuery来完成此功能:
			当鼠标在图片上时，放大图片，并改变图片边框颜色
			当鼠标离开图片时，返回图片原本尺寸，并改变图片边框颜色
	 */
	$(function() {

		//鼠标移入移出功能
		/* 		$("#img_01").mouseout(function() {
		 $("#img_01").removeClass("img");
		 $("#img_01").addClass("img_01");
		 });

		 $("#img_01").mouseenter(function() {
		 $("#img_01").addClass("img");
		 $("#img_01").removeClass("img_01");
		 }); */

		//一种更简便的方式，实现鼠标移入移出功能：模仿鼠标的悬停操作
		$("#img_01").hover(function() {
			$("#img_01").addClass("img");
			$("#img_01").removeClass("img_01");
		}, function() {
			$("#img_01").removeClass("img");
			$("#img_01").addClass("img_01");
		});
	});
</script>

</head>
<body>
	<br> 图片：
	<img id="img_01" src="<%=basePath%>images/2.jpg" width="66" height="66">
</body>
</html>