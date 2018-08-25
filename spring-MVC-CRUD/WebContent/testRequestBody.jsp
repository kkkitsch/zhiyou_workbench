<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testRequestBody page</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	$(function() {
		$('#testRequestBody').click(function() {
			$.ajax({
				url : '<%=basePath%>testRequestBody',/* 请求url */
				type : 'post',/* 请求类型 */
				
				/* 设置请求中包含的数据的类型，此请求中的数据类型为json，必须设置，默认是："application/x-www-form-urlencoded" */
				contentType : 'application/json; charset=utf-8',
				data : '[{"name":"tom","age":12},{"name":"kkk","age":21}]',/* 请求中包含的数据 */
				dataType:'json',/* 请求后，响应回来的数据类型 */
				success : function(result) {/* 成功响应后执行的方法 */
					$.each(result, function(index, value) {/* 遍历响应回来的数据 */
						alert(value.name + ',' + value.age);
					});
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<a id="testRequestBody" href="testRequestBody.jsp">testRequestBody
	</a>
</body>
</html>