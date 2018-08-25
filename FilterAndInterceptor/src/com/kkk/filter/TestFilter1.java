package com.kkk.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

//定义一个过滤器
public class TestFilter1 extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 在DispatcherServlet之前执行
		System.out.println("TestFilter1.........在DispatcherServlet之前执行...................");
		filterChain.doFilter(request, response);
		// 在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
		System.out.println("TestFilter1.........在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后......................");
	}

}
