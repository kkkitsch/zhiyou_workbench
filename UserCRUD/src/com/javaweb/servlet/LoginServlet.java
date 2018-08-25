package com.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaweb.dao.UserDao;
import com.javaweb.entity.User;
import com.javaweb.util.PasswordUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String sessionCode = (String) request.getSession().getAttribute("sessioncode");
		if (logger.isInfoEnabled()) {
			logger.info("页面传过来的code为：{}。session中的验证码为：{}", code, sessionCode);
		}
		// 为什么将sessionCode放在前面这个问题
		/*
		 * 如果从页面中获取的code为null的话 也就是用户没有输入（加入前端没有提示） 此时将报NullPointerExcepiton
		 * if(code.equals(sessionCode)){}
		 */
		// ①首先判断验证码 因为邮箱密码的时候 需要进行数据库的查询 这样减少与数据库的交互 省了查询的时间
		if (!sessionCode.equalsIgnoreCase(code)) {
			request.setAttribute("msg", "验证码不一致 请重新输入");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("获取到的账号邮箱为：{},密码为：{}", email, password);
			}
			// ② 验证码 正确 开始进行数据库的查询 进行校验密码
			UserDao userDao = new UserDao();
			User userByEmail = userDao.getUserByEmail(email);
			if (logger.isInfoEnabled()) {
				logger.info("查询出来的用户为：{}", userByEmail);
			}
			// ③ 从数据库中查询出来的用户不存在
			if (userByEmail == null) {
				request.setAttribute("info", "用户账号不存在");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				// ④ 存在情况 开始加密密码值的比对 因为用户输入的是明文 数据库保存的是密文
				// 对用户输入的明文密码进行加密
				String secPassword = PasswordUtil.createPassword(password);
				// 使用加密后的密码和数据库中的密码进行比对
				if (!userByEmail.getPassword().equals(secPassword)) {
					request.setAttribute("info", "密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} else {
					// 登陆完成 在session中存放用户名
					HttpSession session = request.getSession();
					session.setAttribute("userName", userByEmail.getUsername());

					session.setMaxInactiveInterval(60 * 1);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
