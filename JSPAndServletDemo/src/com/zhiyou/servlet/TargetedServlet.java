package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TargetedServlet")
public class TargetedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TargetedServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 浏览器输出
		System.out.println("target ......");
		response.getWriter().append("Served at: ")
				.append(request.getContextPath() + "=======get request attribute:name=" + request.getAttribute("name"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
