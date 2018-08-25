<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<a href="helloWorldHandler/hello?name=tom">Test_hello world</a>
	<br>
	<a href="helloWorldHandler/jsljfeifjls/antStyle?name=tom">Test_ant Style</a>
	<br>
	<a href="helloWorldHandler/pathVariable/12">Test_pathVariable</a>
	<br>
	<a href="helloWorldHandler/testGet/12">Test GET</a>
	<br>
	<form action="helloWorldHandler/post" method="post">
		<input type="submit" value="testREST_POST">
	</form>
	<form action="helloWorldHandler/delete/21" method="post">
		<input type="hidden" name="_method" value="DELETE"> 
		<input type="submit" value="testREST_DELETE">
	</form>
	<form action="helloWorldHandler/put/21/tom" method="post">
		<input type="hidden" name="_method" value="PUT"> 
		<input type="submit" value="testREST_PUT">
	</form>
	<hr>
	测试获取请求参数，通过形参的方式：
	<form action="helloWorldHandler/testRequestParam" method="post">
		id:<input type="text" name="id">
		<br> 
		name:<input type="text" name="name">
		<br> <input type="submit" value="testRequestParam">
	</form>
	测试获取请求参数，通过pojo的方式：
	<form action="helloWorldHandler/testRequestParamByPojo" method="post">
		id:<input type="text" name="id">
		<br> 
		name:<input type="text" name="name">
		<br> <input type="submit" value="testRequestParamByPojo">
	</form>
	测试获取级联请求参数，通过pojo的方式：
	<form action="helloWorldHandler/testRequestParamByPojo_01" method="post">
		id:<input type="text" name="id">
		<br> 
		name:<input type="text" name="name">
		<br> 
		city:<input type="text" name="address.city">
		<br>
		street:<input type="text" name="address.street">
		<br>
		<input type="submit" name="testRequestParamByPojo_01">
	</form>
	测试获取请求报头：
	<a href="helloWorldHandler/getRequestHeader">获取请求报头</a>
	<br>
	测试获取cookie值：
	<a href="helloWorldHandler/getCookieValue">获取cookie值</a>
	<br>
	测试获取Servlet API：
	<a href="helloWorldHandler/getServletAPI">获取getServletAPI</a>
	<br>
	测试ModelAndView：
	<a href="helloWorldHandler/ModelAndView">获取ModelAndView</a>
	<br>
	测试Map：
	<a href="helloWorldHandler/testMap">获取testMap</a>
	<br>
	测试Model：
	<a href="helloWorldHandler/testModel">获取testModel</a>
	<br>
	测试ModelMap：
	<a href="helloWorldHandler/testModelMap">获取testModelMap</a>
	<br>
	<form action="helloWorldHandler/modelAttribute" >
		<input type="text" name="id" value="007">
		<br>
		<input type="text" name="name" value="tom">
		<br>
		<input type="submit" value="UPDATE">
	</form>
	<br>
	<a href="helloWorldHandler/testJSTL">test JSTL</a>
	
	<br>
	<a href="helloWorldHandler/testMyView">测试自定义视图</a>
	


</body>
</html>