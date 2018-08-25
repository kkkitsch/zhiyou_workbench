package com.javaweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class LoginFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String requestURI = httpServletRequest.getRequestURI();
		// 对login.jsp 和生成验证码的servlet 进行放行 其他请求过滤
		if (!requestURI.contains("login") && !requestURI.contains("validateCode")) {
			// 判断session是否用用户登陆的信息
			String userName = (String) httpServletRequest.getSession().getAttribute("userName");
			if (logger.isInfoEnabled()) {
				logger.info("session中的用户为：{}", userName);
			}
			if (userName == null) {
				httpServletRequest.setAttribute("loginInfo", "请登陆");
				httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
				// httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
			} else {
				chain.doFilter(httpServletRequest, httpServletResponse);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
