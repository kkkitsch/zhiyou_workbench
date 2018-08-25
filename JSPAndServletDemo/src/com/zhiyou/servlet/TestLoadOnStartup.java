package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/*
    使用注解的方式配置Servlet
 
    并制定urlPattern(即：value)和加载时机

  loadOnStartup:在启动在启动时加载元件负载指示就加载这个servlet（实例化并调用其（））对Web应用程序的启动。
    这些元素的可选内容必须是一个整数，指示应加载servlet的顺序。
    如果值是负整数，或者元素不存在，容器可以自由加载servlet。
    如果该值是正整数或0，则容器必须在部署应用程序时加载和初始化servlet。
    容器必须保证servlet标有低整数在servlet标有高整数装。
    容器可选择顺序加载Servlet具有相同的负载启动值。
 */
@WebServlet(value = { "/TestLoadOnStartup" }, loadOnStartup = 1)
public class TestLoadOnStartup implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("TestLoadOnStartup启动，执行初始化方法......");

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}

}
