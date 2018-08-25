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
p {
	border: 1px solid #abcdef;
	width: 240px;
	height: 180px;
	display: none;
}

div {
	width: 30px;
	height: 30px;
	background: #abcdef;
	position: absolute;
	left: 50px;
	top: 50px;
}

img {
	width: 100px;
	height: 100px;
	background: #abcdef;
	position: absolute;
	left: 100px;
	top: 100px;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easing/jquery.easing.js"></script>
<script>
	$(function() {
		//animate()、delay()延迟加载动画，并使用easing动画效果
		$("#move").click(function() {
			
			$("div").delay(1000).animate({
				'top' : '280px',
			}, 2000, 'easeOutElastic').animate({
				'left' : '500px',
			}, 2000, 'easeInOutElastic').animate({
				'top' : '50px',
			}, 2000, 'easeInElastic').animate({
				'left' : '50px',
			}, 2000, 'easeInOutBounce');
			
			$("img").delay(1000).animate({
				'top' : '280px',
			}, 2000, 'easeOutElastic').animate({
				'left' : '600px',
			}, 2000, 'easeInOutElastic').animate({
				'top' : '150px',
			}, 2000, 'easeInElastic').animate({
				'left' : '150px',
			}, 2000, 'easeInOutBounce');
			
		});

		//stop()
		$("#stop").click(function() {
			/*
				false,false:跳过此动画，执行下一个动画
				true,true:停止动画
				false,true:跳过动画过程，直接到动画结果
				true,false:暂停动画
			 */
			$("div").stop(true, false);
			$("img").stop(true, false);
		});

		//dequeue()
		$("#dequeue").click(function() {
			$("div").dequeue();
			$("img").dequeue();
		});

		//finish() 直接结束所有动画，调到最后部分
		$("#finish").click(function() {
			$("div").finish();
			$("img").finish();
		});
	});
</script>
</head>
<body>
	<button id="move">移动</button>
	<button id="stop">停止</button>
	<button id="dequeue">出列</button>
	<button id="finish">完成</button>
	<div></div>
	<img src="<%=basePath%>images/1.jpg">
</body>
</html>