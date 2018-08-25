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
<title>json base</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script>
	$(function() {

		$("#button1").click(
				function() {
					//定义json对象
					var jsonObj = {
						"name" : "kkkitsch",
						"age" : 21,
						"address" : {
							"city" : "郑州",
							"street" : "中原路"
						},
						"method" : function() {
							console.log("this is a function of method!");
						}
					};
					var per = "姓名：" + jsonObj.name + ",年龄：" + jsonObj.age
							+ ",地址：" + jsonObj.address.city + " "
							+ jsonObj.address.street;

					/* 控制台输出json数据信息 */
					console.log(per);

					//调用方法
					jsonObj.method();
				});

		$("#button2").click(
				function() {
					//定义json数组
					var jsonObj = [ {
						"name" : "kkkitsch",
						"age" : 21,
						"address" : {
							"city" : "郑州",
							"street" : "中原路"
						}
					}, {
						"name" : "tomcluse",
						"age" : 21,
						"address" : {
							"city" : "周口",
							"street" : "华佗路"
						}
					}, {
						"name" : "Steven",
						"age" : 21,
						"address" : {
							"city" : "泰安",
							"street" : "泰山路"
						}
					} ];
					var per = "姓名：" + jsonObj[1].name + ",年龄：" + jsonObj[1].age
							+ ",地址：" + jsonObj[1].address.city + " "
							+ jsonObj[1].address.street;

					/* 控制台输出json数据信息 */
					console.log(per);
				});

		$("#eval")
				.click(
						function() {
							var str = '{"name" : "kkkitsch","age" : 21,"address" : {"city" : "郑州","street" : "中原路"}}';
							var hello = "alert('hello eval')";

							//将字符串转变成可执行的JS代码
							eval(hello);

							//需要加括号！
							var jsonStr = eval("(" + str + ")");
							alert(jsonStr.name);
							alert(jsonStr.age);
							alert("地址：" + jsonStr.address.city + " "
									+ jsonStr.address.street);
						});
	});
</script>
</head>
<body>
	<button id="button1">json对象</button>
	<button id="button2">json数组</button>
	<button id="eval">eval</button>
</body>
</html>