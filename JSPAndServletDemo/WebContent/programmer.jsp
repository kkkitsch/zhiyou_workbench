<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入多个包可以用这种方式 -->
<%@ page import="java.io.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 语法</title>
</head>
<body>
	Hello World!
	<br />
	<%
		out.println("Your IP address is " + request.getRemoteAddr());
	%>
	<%!int a, b, c;%>

	<%!int i = 0;%>
	<br> i=<%=i%>
	<br> a=<%=a%>
	<br> b=<%=b%>
	<br> c=<%=c%>

	<h2>自动刷新实例</h2>
	<%
		// 设置每隔1秒刷新一次
		response.setIntHeader("Refresh", 1);
		// 获取当前时间
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		out.println("当前时间为: " + CT + "\n");
	%>

	<h2>include 动作实例</h2>
	<jsp:include page="start.jsp" flush="true" />

	<br> jsp动作练习：
	<jsp:useBean id="test" class="com.zhiyou.bean.TestBean" />

	<jsp:setProperty name="test" property="message" value="菜鸟教程..." />

	<p>输出信息....</p>

	<jsp:getProperty name="test" property="message" />





	<%!private int initVar = 0;
	private int serviceVar = 0;
	private int destroyVar = 0;%>

	<%!public void jspInit() {
		initVar++;
		System.out.println("jspInit(): JSP被初始化了" + initVar + "次");
	}

	public void jspDestroy() {
		destroyVar++;
		System.out.println("jspDestroy(): JSP被销毁了" + destroyVar + "次");
	}%>

	<%
		serviceVar++;
		System.out.println("_jspService(): JSP共响应了" + serviceVar + "次请求");

		String content1 = "初始化次数 : " + initVar;
		String content2 = "响应客户请求次数 : " + serviceVar;
		String content3 = "销毁次数 : " + destroyVar;
	%>
	<h1>菜鸟教程 JSP 测试实例</h1>
	<p><%=content1%></p>
	<p><%=content2%></p>
	<p><%=content3%></p>
</body>
</html>