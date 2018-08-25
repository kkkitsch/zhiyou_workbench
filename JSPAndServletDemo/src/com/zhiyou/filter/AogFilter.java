package com.zhiyou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(filterName = "AogFilter", urlPatterns = { "/value1", "/value3" })
public class AogFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site");
		// 输出初始化参数
		System.out.println("第二个过滤器被初始化......初始化网站名称: " + site);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置相应字符编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 输出站点名称
		System.out.println("第二个过滤器正在工作......");
		// 把请求传回过滤链
		chain.doFilter(request, response);
		System.out.println("第二个过滤器正在工作后......");
	}

	@Override
	public void destroy() {
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
		System.out.println("第二个过滤器被销毁......");
	}

}
