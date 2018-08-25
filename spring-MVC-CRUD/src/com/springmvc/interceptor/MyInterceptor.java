package com.springmvc.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	// 调用业务方法或者下一个拦截器之前需要执行的方法
	// 如果返回值为true，拦截器方法执行完毕，继续执行下一个拦截器或者业务方法
	// 如果返回false，中断执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Date date = new Date();
		int hour = date.getHours();
		if (hour >= 9 && hour <= 21) {
			System.out.println("拦截器执行了......");
			response.sendRedirect("/spring-MVC-CRUD/error.jsp");
			return true;
		} else {

			return false;
		}
	}

	// 调用业务方法之后，渲染视图之前
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	// 渲染视图之后
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception exception) throws Exception {

	}
}
