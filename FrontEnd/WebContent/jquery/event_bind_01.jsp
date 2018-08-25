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
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		//one事件，只能使用一次点击事件
		$("#button_01").one("click", function() {
			alert("点击了一次按钮");
		});

		//实现one事件的功能
		$("#button_02").bind("click", function() {
			alert("点击了一次按钮");
			//解除绑定
			$(this).unbind("click");
		});

		/* div元素的显示与隐藏  */
		$(function() {
			$("#button_03").click(function() {

				if ($("#div_02").is(":visible")) {
					$("#div_02").hide('slow');
				} else {
					$("#div_02").show('fast');
				}
			});
		});

	});
</script>
</head>
<body>
	<input id="button_01" type="button" value="按钮1">
	<input id="button_02" type="button" value="按钮2">
	<input id="button_03" type="button" value="更多">
	<div id="div_01">
		千秋无绝色<br> 悦目是佳人<br> 管中窥豹<br> 可见一斑<br> <br>
		<div id="div_02" style="visibility: visible;">
			上德不古<br>下德不武<br>顾左右而言他<br>观之不似人君
		</div>
	</div>
</body>
</html>