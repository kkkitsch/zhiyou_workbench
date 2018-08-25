package com.zhiyou.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public StartServlet() {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		/*
		 * 单个获取初始化参数，ServletContext和ServletConfig的区别：
		 * 
		 * ServletContext配置在web-app根节点，对应的时web.xml中的<context-param>所有的servlet类，
		 * 只要获取了ServeltContext对象均可以使用
		 * 
		 * ServletConfig对应的是配置在servlet中的<init-param>，获取的是servlet类初始化参数
		 */
		String value1 = config.getInitParameter("initParam1");
		String value2 = config.getInitParameter("initParam2");
		System.out.println("value1: " + value1 + "，value2： " + value2);

		/*
		 * 获取所有初始化参数，返回值类型为Enumeration<String>，循环迭代输出
		 * 
		 * 废弃的接口：Enumeration
		 * 
		 * Enumeration接口是JDK1.0时推出的，是最好的迭代输出接口，最早使用Vector（现在推荐使用ArrayList）
		 * 时就是使用Enumeration接口进行输出。虽然Enumeration是一个旧的类，但是在JDK1.
		 * 5之后为Enumeration类进行了扩充，增加了泛型的操作应用。
		 * 
		 * Enumeration接口常用的方法有hasMoreElements()（判断是否有下一个值）和
		 * nextElement()（取出当前元素），这些方法的功能跟Iterator类似，只是Iterator中存在删除数据的方法，
		 * 而此接口不存在删除操作。 为什么还要继续使用Enumeration接口
		 * 
		 * Enumeration和Iterator接口功能相似，而且Iterator的功能还比Enumeration多，
		 * 那么为什么还要使用Enumeration？这是因为java的发展经历了很长时间，
		 * 一些比较古老的系统或者类库中的方法还在使用Enumeration接口，因此为了兼容，还是需要使用Enumeration。
		 */
		Enumeration<String> initParameterNames = config.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			System.out.println(initParameterNames.nextElement());
		}

		/*
		 * 获取ServletContext初始化参数
		 */
		ServletContext sc = config.getServletContext();
		String value3 = sc.getInitParameter("contextParam1");
		String value4 = sc.getInitParameter("contextParam2");
		System.out.println("value3: " + value3 + "，value4： " + value4);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 使用 GBK 设置中文正常显示
		response.setCharacterEncoding("GBK");
		response.getWriter().write("菜鸟教程：http://www.runoob.com");

		// 获取参数
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println("parameter1:" + param1);
		System.out.println("parameter2:" + param2);

		// URL URI
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println("uri=" + uri + ",url=" + url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
