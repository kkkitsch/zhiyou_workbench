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
<title>微博发布框</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	//模仿微博发布框，不能超过140字
	$(function() {
		var maxLength = 140;//设置最大长度
		$("textarea").keyup(function() {//键盘按下事件
			var length = $(this).val().length;//获取当前发布框中的字数的长度
			$("strong").text(maxLength - length);//最大长度-当前长度
			if (parseInt($("strong").text()) < 0) {//转换成int类型
				$("strong").text("0");//如果超过140时，将可输入字数设置为0
				var val = $(this).val().substring(0, 140);//截取发布框中的前140个字
				$(this).val(val);//将前140个字赋值到当前发布框，140字之后的删除
			}
		});
	});
</script>
</head>
<body>
	<textarea rows="7" cols="28"></textarea>
	<span>你还可以输入<strong>140</strong>个字
	</span>
</body>
</html>