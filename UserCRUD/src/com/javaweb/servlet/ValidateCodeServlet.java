package com.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

@WebServlet("/validateCode")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateCodeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 告诉客户端不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);

		ValidateCode vc = new ValidateCode(110, 25, 4, 9);

		String code = vc.getCode();// 得到生成的字符
		// 将验证码存放到session中
		request.getSession().setAttribute("sessioncode", code);

		vc.write(response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}