<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
textarea {
	width: 300px;
	height: 180px;
	border: 1px solid #abcdef; /* 设置四个边框样式 */
}

div {
	width: 300px;
	height: 180px;
	border: 1px solid #abcdef; /* 设置四个边框样式 */
}
</style>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	/* 遇到的问题：
		 代码格式有错：不执行任何代码
		 解决缓存问题：在URL上加上随机数参数
		 
		div标签：里面的文本内容有<br>会解析成换行，原来文本里的换行被擦除
		textarea标签：里面的文本内容有<br>不会解析成换行，原来文本里的换行依旧是换行
		
		解析json格式很重要
	 */

	$(function() {
		/*ajax中，执行ajax方法之前调用的方法，执行ajax之后调用的方法，并且执行延迟操作800ms  */
		$(document).ajaxStart(function() {
			$("#loading").show();
		});
		$(document).ajaxStop(function() {
			setTimeout(function() {
				$("#loading").hide().delay(2000);
			}, 800);
		});

		//练习使用load方法
		$("#action").click(function() {
			//通过attr方法获取超链接中的值
			var source = $('a').attr("href");
			//设置一个参数
			var args = {
				"date" : new Date()
			};
			//load(url,data,callback)
			$("#content").load(source, args, function() {
				/* 通过jquery可以操作DOM节点，$("#content")获取的是一个DOM节点，如果想使用jquery的方法，需要把this放在$()中 */
				alert(this);
				$(this).show().html("当前时间：" + args.date);
			});
		});

		//从页面中获取json类型的数据，并输出json数据到当前页面上
		$("#json").click(
				function() {
					$.ajax({
						type : "get", //请求类型
						url : "kkk.json?" + Math.random(), //请求地址
						data : "loginName=" + $("#loginName").val(), //向请求发送的参数
						dataType : "json", //返回结果类型
						success : function(data) { //请求成功后的回调函数
							var str = "姓名：" + data.name + ",年龄：" + data.age
									+ ",地址：" + data.address.city + " "
									+ data.address.street;
							//将json数据加入到textarea标签中
							$("#content").show().html(str);
							$("#poem").hide();
						}
					});
				});

		//解析json数组
		$("#news").click(
				function() {
					$.ajax({
						type : "post", //请求类型
						url : "news.json?" + Math.random(), //请求地址
						dataType : "json", //返回结果类型
						success : function(data) { //请求成功后的回调函数
							for (var i = 0, con = ""; i < data.length; i++) {
								con = con + "姓名：" + data[i].name + ",年龄："
										+ data[i].age + ",地址："
										+ data[i].address.city + " "
										+ data[i].address.street + "<br>";
								$("#content").show().html(con);
								$("#poem").hide();
							}
						}
					});
				});

		//从页面中获取text类型的数据，并输出文本内容数据到当前页面上
		$("#text").click(function() {
			$.ajax({
				type : "post", //请求类型
				url : "<%=basePath%>json/article.txt", //请求地址
				data : "loginName=" + $("#loginName").val(), //向请求发送的参数
				dataType : "text", //返回结果类型
				success : function(data) { //请求成功后的回调函数
					//将json数据加入到textarea标签中
					$("#poem").show().html(data);
					$("#content").hide();
				}
			});
		});
	});
</script>
</head>
<body>
	<a href="<%=basePath%>json/article.txt">article</a>
	<button id="action">action</button>
	<button id="json">json</button>
	<button id="news">news</button>
	<button id="text">text</button>
	<img id="loading" src="<%=basePath%>static/images/ajax-loader.gif"
		style="display: none">
	<br>
	<div id="content" style="display: none"></div>
	<textarea id="poem" style="display: none"></textarea>
</body>
</html>