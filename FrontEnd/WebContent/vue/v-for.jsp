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
<title>v-for</title>
<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>
	$(function() {

		/* 循环使用 v-for 指令 */
		new Vue({
			el : '#app',
			data : {
				sites : [ {
					name : 'Runoob',
					age : 12
				}, {
					name : 'Google',
					age : 12
				}, {
					name : 'Taobao',
					age : 12
				} ]
			}
		});

		/* 模板中使用 v-for */
		new Vue({
			el : '#app-2',
			data : {
				sites : [ {
					name : 'Runoob',
					age : 12
				}, {
					name : 'Google',
					age : 12
				}, {
					name : 'Taobao',
					age : 12
				} ]
			}
		});

		/* v-for 可以通过一个对象的属性来迭代数据 */
		new Vue({
			el : '#app-3',
			data : {
				object : {
					name : '菜鸟教程',
					url : 'http://www.runoob.com',
					slogan : '学的不仅是技术，更是梦想！'
				}
			}
		});

		/* 不仅如此，在迭代属性输出的之前，v-for会对属性进行升序排序输出 */
		new Vue({
			el : '#app-3-1',
			data : {
				object : {
					2 : '学的不仅是技术，更是梦想！',
					1 : '菜鸟教程',
					0 : 'http://www.runoob.com'
				}
			}
		});

		/* 你也可以提供第二个的参数为键名 */
		new Vue({
			el : '#app-4',
			data : {
				object : {
					name : '菜鸟教程',
					url : 'http://www.runoob.com',
					slogan : '学的不仅是技术，更是梦想！'
				}
			}
		});

		/* 第三个参数为索引 */
		new Vue({
			el : '#app-5',
			data : {
				object : {
					name : '菜鸟教程',
					url : 'http://www.runoob.com',
					slogan : '学的不仅是技术，更是梦想！'
				}
			}
		});

		/* v-for 迭代整数 */
		new Vue({
			el : '#app-6'
		});

		/* v-for 循环数组 */
		new Vue({
			el : '#app-7'
		});

		/* v-for 99乘法表 */
		new Vue({
			el : '#app-8'
		});

		/* 遍历对象的时候可以处理嵌套 */
		new Vue({
			el : '#app-9',
			data : {
				object : {
					name : '菜鸟教程',
					url : 'http://www.runoob.com',
					slogan : '学的不仅是技术，更是梦想！',
					obj2 : {
						y : "嵌套对象的属性1",
						z : "嵌套对象的属性2"
					}
				}
			}
		})

	});
</script>
</head>
<body>

	<div id="app">
		<ol>
			<li v-for="site in sites">{{ site.name +"---"+site.age}}</li>
		</ol>
	</div>


	<ul id="app-2">
		<template v-for="site in sites">
		<li>{{ site.name }}</li>
		<li>{{ site.age }}</li>
		<li>--------------</li>
		</template>
	</ul>

	<div id="app-3">
		<ul>
			<li v-for="value in object">{{ value }}</li>
		</ul>
	</div>

	<div id="app-3-1">
		<ul>
			<li v-for="n in object">{{ n }}</li>
		</ul>
	</div>

	<div id="app-4">
		<ul>
			<li v-for="(value, key) in object">{{ key }} : {{ value }}</li>
		</ul>
	</div>

	<!-- (value, key, index)当中，第一个为值，第二个为键，第三个为索引下标，必须这样定义，这是有顺序的  -->
	<div id="app-5">
		<ul>
			<li v-for="(value, key, index) in object">{{ index }}. {{ key
				}}: {{ value }}</li>
		</ul>
	</div>

	<div id="app-6">
		<ul>
			<li v-for="n in 10">{{ n }}</li>
		</ul>
	</div>

	<div id="app-7">
		<ul>
			<li v-for="n in [1,3,5]">{{ n }}</li>
		</ul>
	</div>

	<div id="app-8">
		<div v-for="n in 9">
			<b v-for="m in n"> {{m}}*{{n}}={{m*n}} </b>
		</div>
	</div>

	<div id="app-9">
		<ul>
			<li v-for="(value,key,index) in object">
				<p v-if="typeof value !='object'">{{value}}....{{ index }}</p>
				<p v-else>{{key}}....{{index}}</p>
				<ul v-if="typeof value == 'object'">
					<li v-for="(value, key, index) in value">
						{{key}}:{{value}}....{{ index }}
					</li>
				</ul>
			</li>
		</ul>
	</div>

</body>
</html>