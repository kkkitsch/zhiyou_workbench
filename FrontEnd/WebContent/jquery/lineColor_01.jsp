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
<!-- <style>
div {
	height: 30;
	line_height: 30;
}
</style> -->
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/*
		让奇数行的颜色变成蓝色，偶数行变成粉色
	 */
	$(function() {
		$("li:even").css("background", "blue");
		$("li:odd").css("background", "pink");
	});

	//点击按钮，确定选中的个数
	$(function() {
		$("#button").click(function() {
			var length = $("input:checked").length
			alert("被选中的个数：" + length);
		});
	});

	//基本过滤选择器
	$(function() {
		//让p标签中第一个的背景为绿色
		$("p:first").css("background", "green");
		//让p标签中最后一个的背景为粉色
		$("p:last").css("background", "pink");
		//让p标签中的下标为3的的背景为绿色
		$("p:eq(3)").css("background", "blue");
		//让p标签中下标大于3的背景为绿色
		$("p:gt(3)").css("background", "blue");
		//让p标签中下标小于3的背景为绿色
		$("p:lt(3)").css("background", "blue");
		//让p标签中除了id为p_01的之外的背景为绿色
		$("p:not('#p_01')").css("background", "blue");
	});

	//内容过滤选择器
	$(function() {
		//让div标签中包含管的背景为绿色
		$("div:contains('管')").css("background", "blue");
		//让div标签中包含管的背景为绿色，并且同级标签隐藏
		//$("div:contains('管')").show().siblings().hide();
		//让div标签中包含strong标签的背景为绿色
		$("div:has('strong')").css("background", "blue");

	});
</script>

</head>
<body>
	<div id="div_01">
		<ul id="ul_id">
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
		</ul>
		<ol id="ol_id">
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
			<li>列表框</li>
		</ol>
	</div>

	<div>一叶障目</div>
	<div>
		<strong></strong> 不见泰山
	</div>
	<div>管中窥豹</div>
	<div></div>
	<div>可见一斑</div>
	<div>蜡笔小新</div>
	<br>

	<input type="checkbox" checked="checked">选项
	<input type="checkbox" checked="checked">选项
	<input type="checkbox" checked="checked">选项
	<input type="checkbox">选项
	<input type="checkbox">选项
	<input type="checkbox">选项
	<br>
	<button id="button">确定个数</button>
	<br>
	<br>
	<p>第1个标签</p>
	<p>第2个标签</p>
	<p id="p_01">第3个标签</p>
	<p>第4个标签</p>
	<p>第5个标签</p>



</body>
</html>