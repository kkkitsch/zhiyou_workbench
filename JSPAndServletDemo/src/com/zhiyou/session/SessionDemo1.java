package com.zhiyou.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SessionDemo1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置字符编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		response.getWriter().append("Served at: ").append(request.getContextPath() + ".........");

		// 使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();

		// 将数据存储到session中
		session.setAttribute("sessionAttr", "value1");

		// 设置session的生命周期
		session.setMaxInactiveInterval(500);

		// 获取session的Id
		String sessionId = session.getId();

		// 判断session是不是新创建的
		if (session.isNew()) {
			response.getWriter().append("session 创建成功，session的id是：" + sessionId);
		} else {
			response.getWriter().append("该session 已经在服务器中存在了，id是：" + sessionId);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
