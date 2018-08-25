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
<style>
* {
	padding: 0;
	margin: 0;
}

ul {
	list-style-type: none;
}

#ul {
	height: 30px;
	margin-bottom: 10px;
}

#ul li {
	height: 30px;
	line-height: 30px;
	padding: 0 15px; /* 元素的填充 */
	border: 1px solid #abcdef; /* 设置四个边框样式 */
	float: left;
	margin-right: 3px; /* 设置元素的右边距 */
	cursor: pointer; /* 光标呈现为指示链接的指针（一只手） */
}

#ul li.current {
	background: pink;
}

body {
	margin: 50px;
}

#content div {
	width: 300px;
	height: 200px;
	border: 1px solid #abcdef;
	display: none;
}

#content div.show {
	display: block;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {
		//点击当前tab框触发的事件
		$("#ul li").click(function() {
			//让当前框添加属性class，并让同级的框移除属性class
			$(this).addClass('current').siblings().removeClass('current');
			//让当前框对应的文本显示，不对应的文本隐藏
			$("#content>div").eq($(this).index()).show().siblings().hide();
		});
	});
</script>

</head>
<body>
	<ul id="ul">
		<li class="current">java</li>
		<li>php</li>
		<li>python</li>
	</ul>
	<div id="content">
		<div class="show">java的介绍</div>
		<div>php的介绍</div>
		<div>Python的介绍</div>
	</div>
</body>