package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestForward")
public class TestForward extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public TestForward() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 设置一个请求属性
		request.setAttribute("name", "kkk");

		// 将请求转发给工程内部
		request.getRequestDispatcher("/TargetedServlet").forward(request, response);

		// 请求转发至外部链接
		// request.getRequestDispatcher("https://www.baidu.com/").forward(request,
		// response);

		response.getWriter().print("this is kkk");

		System.out.println("这是请求转发之后的代码");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
