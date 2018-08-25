package com.zhiyou.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestSendRedict")
public class TestSendRedict extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestSendRedict() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 给定请求属性
		request.setAttribute("name", "kkkitsch");

		response.sendRedirect(request.getContextPath() + "/TargetedServlet");

		System.out.println("这是重定向之前的代码");

		// 请求转至外部
		// response.sendRedirect("https://www.baidu.com/");

		System.out.println("这是重定向之后的代码");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
