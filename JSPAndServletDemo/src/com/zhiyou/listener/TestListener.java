package com.zhiyou.listener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestListener")
public class TestListener extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestListener() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TestListener的doPost()方法执行中......");

		/*
		 * 测试ServletContextListener监听器
		 */
		ServletContext servletContext = request.getServletContext();

		/*
		 * 测试ServletContextAttributeListener监听器
		 */
		servletContext.setAttribute("SCAL1", "SCAL1");
		servletContext.setAttribute("SCAL1", "SCAL11");
		servletContext.removeAttribute("SCAL1");

		/*
		 * 测试ServletRequestListener、ServletRequestAttributeListener
		 */
		request.setAttribute("SRAL1", "SRAL1");
		request.setAttribute("SRAL1", "SRAL11");
		request.removeAttribute("SRAL1");

		/*
		 * 测试ServletRequestListener、ServletRequestAttributeListener
		 */
		HttpSession session = request.getSession();
		session.setAttribute("HS1", "HS1");
		session.setAttribute("HS1", "HS11");
		session.removeAttribute("HS1");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
