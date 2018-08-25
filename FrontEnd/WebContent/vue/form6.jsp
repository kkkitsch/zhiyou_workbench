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
<title>双向数据绑定</title>

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/Vue.js"></script>
<script>

	$(function() {
		var vm = new Vue({
			el:'#app',
			data:{
				checked:false,
				
				/* checkedNames中的值和复选框中的值一致时复选框的按钮才会被选中 */
				checkedNames : [],
				checkedArr : [ "Runoob", "Taobao", "Google" ]
			},
			methods : {
				changeAllChecked : function() {
					if (this.checked) {
						this.checkedNames = this.checkedArr;
					} else {
						this.checkedNames = [];
					}
				}
			},
			watch : {
				checkedNames : function() {
					if (this.checkedNames.length == this.checkedArr.length) {
						this.checked = true;
					} else {
						this.checked = false;
					}
				}
			}
		});
	});
</script>
</head>
<body>
<div id="app">

	<p>
		全选：
	</p>
	<input type="checkbox" id="checkbox" v-model="checked" @change="changeAllChecked()">
	<label for="checkbox">
		{{checked}}
	</label>
	<p>
		多个复选框：
	</p>
	<input type="checkbox" id="runoob" value="Runoob" v-model="checkedNames">
	<label for="runoob">
		Runoob
	</label>
	<input type="checkbox" id="google" value="Google" v-model="checkedNames">
	<label for="google">
		Google
	</label>
	<input type="checkbox" id="taobao" value="Taobao" v-model="checkedNames">
	<label for="taobao">
		taobao
	</label>
	<br>
	<span>
		选择的值为:{{checkedNames}}
	</span>
</div>
	
</body>
</html>