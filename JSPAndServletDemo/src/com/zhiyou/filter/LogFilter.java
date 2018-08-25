package com.zhiyou.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*
 * 属性filterName声明过滤器的名称,可选
 * 
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.也可以指定多种过滤模式(指定要过滤的URL模式是必选属性)
 * 
 * 在web.xml中配置filter的时候，可以指定哪一个filter先执行，哪一个filter后执行，这是通过每个filter-mapping在web.xml中出现的先后顺序来确定的。通过注解配置filter时，没有专门的指令来配置filter执行的先后。确定filter执行的先后是根据filter类名的字母表顺序
 * 
 * 在配置urlPatterns时，一定不能忘记加/
 * 
 * 注解虽然方便了开发人员，但在后期会让维护和调试成本增加
 */

//@WebFilter(filterName = "LogFilter", urlPatterns = { "/value1", "/value2" })
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site");
		// 输出初始化参数
		System.out.println("第一个过滤器被初始化......初始化网站名称: " + site);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 设置相应字符编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 输出站点名称
		System.out.println("第一个过滤器正在工作......");
		// 把请求传回过滤链
		chain.doFilter(request, response);
		System.out.println("第一个过滤器正在工作后......");
	}

	@Override
	public void destroy() {
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
		System.out.println("第一个过滤器被销毁......");
	}

}
