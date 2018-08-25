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
	width: 100px;
	height: 100px;
	background: #abcdef;
	position: absolute;
	left: 280px;
	top: 150px;
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	//代替toggle方法
	//jQuery中的基础动画
	/* 	$(function() {
	 $("input").click(function() {

	 if ($("span").is(":visible")) {
	 $("span").hide('slow');
	 } else {
	 $("span").show('fast');
	 }
	 });
	 }); */

	//jQuery中的渐变动画
	/* 	$(function() {
	 $("input").click(function() {
	 if ($("span").is(":visible")) {
	 $("span").fadeOut(2000);//2000ms内淡出
	 } else {
	 $("span").fadeIn(2000);//2000ms内淡入
	 }

	 $("span").fadeTo(2000, 0.3, function() {
	 alert("fadeTo方法执行")
	 });//2000ms内透明度opacity淡到0.3
	 });
	 }); */

	//fadeToggle()=fadeIn()+fadeOut()
	$(function() {
		$("input").click(function() {
			$("span").fadeToggle(2000);
		});
	});

	/* 	//滑动向下展开
	 $(function() {
	 $('a').click(function() {
	 $('p').slideDown(500);
	 $("a").text("收起");
	 });
	 });
	 //滑动向上收起
	 $(function() {
	 $('a').click(function() {
	 $('p').slideUp(500);
	 $("a").text("展开");
	 });
	 }); */

	//slideToggle()=slideDown()+slideUp()
	$(function() {
		$("a").click(function() {
			$("p").slideToggle(500, function() {
				if ($("a").text() == "展开") {
					$("a").text("收起");
				} else {
					$("a").text("展开");
				}
			});
		});
	});

	//自定义动画
	$(function() {
		$("#button").click(function() {
			/* 在3000ms内移动到指定位置，移动完成后执行回调函数，将div背景颜色变成黄色，
			如果直接在animate方法后加上css方法，会在刚移动时就变成黄色 */
			$("div").animate({
				'left' : '800px',
				'top' : '456px',
				'opacity' : '0.2'
			}, 3000, function() {
				$("div").css('background', '#f90')
			});
		});
	});
</script>
</head>
<body>
	<input type="text" value="kkk">
	<span style="display: none">this is span</span>
	<br>
	<br>
	<a href="###">展开</a>
	<p>古之所谓豪杰之士，必有过人之节。人情有所不能忍者，匹夫见辱，拔剑而起，挺身而斗，此不足为勇也。
		天下有大勇者，卒然临之而不惊，无故加之而不怒。此其所挟持者甚大，而其志甚远也。</p>
	<br>
	<br>
	<button id="button">移动</button>
	<div></div>
</body>
</html>