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

<script src="<%=basePath%>static/jquery-3.3.1.js"></script>
<script src="<%=basePath%>static/cxselector/jquery.cxselect.js"></script>
<script>
	$(function() {
		// selects 为数组形式，请注意顺序 
		$('#element_id').cxSelect({
			//url选择自己的json文件路径			
			url : '<%=basePath%>static/cxselector/cityData.json',
			selects : [ 'province', 'city', 'area' ],
			nodata : 'none'
		});
	});
</script>
</head>
<body>
	<div id="element_id">
		<ul>
			<li>省份：<select class="province" data-value="河南省"></select></li>
			<li>城市：<select class="city" data-value="周口市"></select></li>
			<li>区县：<select class="area" data-value="沈丘县">
			<option></option>
			</select></li>
		</ul>
	</div>
</body>
</html>