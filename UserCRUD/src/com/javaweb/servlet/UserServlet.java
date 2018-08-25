package com.javaweb.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaweb.dao.UserDao;
import com.javaweb.entity.PageBean;
import com.javaweb.entity.User;
import com.javaweb.service.PageService;
import com.javaweb.util.PasswordUtil;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(UserServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		if (logger.isInfoEnabled()) {
			logger.info("获取到的URI为：{}", requestURI);
		}
		// eg:"/javaweb_crud_v3/user/list" => "","javaweb_crud-v3","user","list"
		String[] splitURI = requestURI.split("/");
		if (logger.isInfoEnabled()) {
			logger.info("截取到的URI中包含的操作为为：{}", splitURI[3]);
		}
		switch (splitURI[3]) {
		case "add":
			addUser(request, response);
			break;
		case "delete":
			deleteUser(request, response);
			break;
		// 预修改 用于回显修改的数据
		case "preUpdate":
			preUpdateUser(request, response);
			break;
		// 提交修改的操作
		case "update":
			updateUser(request, response);
			break;
		case "list":
			listUser(request, response);
			break;
		// 没有该请求路径的时候
		default:
			nonSuchUrl(request, response);
			break;
		}

	}

	private void nonSuchUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print("请检查你的路径");
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 从页面中获取体积的参数 这些参数 是可以通过转发 到某一个页面 再重新获取的（<%request.getParameter("") %>)
		// 如果想通过EL表达式获取的话 需要使用request.setAttribute("","");

		// 参数域过多的情况 需要对属性一个一个的set值操作 过程繁琐 需要封装 用Apache提供的工具类
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpwd = request.getParameter("confirmpwd");

		// ================================================
		// 参数域过多的情况下 使用Apache工具类 进行属性域的填充
		User user = new User();
		try {
			// Apache 工具类 直接对对象进行渲染
			BeanUtils.populate(user, request.getParameterMap());
			if (logger.isInfoEnabled()) {
				logger.info("获取的所有参数域为：{}", request.getParameterMap());
			}
			if (logger.isInfoEnabled()) {
				logger.info("封装的用户对象为：{}", user);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// =================================================

		// 进行日志输出 查看获取的参数
		if (logger.isInfoEnabled()) {
			logger.info("获取到的用户名为：{},邮箱为：{}", username, email);
		}
		// 两次密码不一致 需要重新添加
		if (password.equals(confirmpwd)) {
			// 需不需要对username email password..... 进行对象的封装
			// 如果需要的话 该如何处理??????
			UserDao userDao = new UserDao();
			String createPassword = PasswordUtil.createPassword(password);
			boolean addFlag = userDao.addUser(username, email, createPassword);
			// 添加成功 重定向到查询页面 简单粗暴有效
			// 显示一个页面 告诉你3秒后跳转 or 直接跳转??????
			if (addFlag) {
				// 简单的模拟
				response.getWriter().println("用户添加成功，3秒后跳转");
				response.setHeader("refresh", "3;url=" + request.getContextPath() + "/user/list");
				// response.sendRedirect("listusers");
			} else {
				// 添加失败 得用转发 用于回显用户填写的信息 用户只需要修改错误的信息字段即可 其他不需要修改 也不需要重新填写
				request.getRequestDispatcher("/useradd.jsp").forward(request, response);
			}
		} else {
			// setAttribute这种形式 是可以使用EL表达式 进行获取值的
			request.setAttribute("msg", "两次密码不一致");
			request.getRequestDispatcher("/useradd.jsp").forward(request, response);
		}

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (logger.isInfoEnabled()) {
			logger.info("要修改的数据为：用户ID{}，用户名{}，邮箱{}", id, username, email);
		}
		// 对修改的密码进行加密
		String createPassword = PasswordUtil.createPassword(password);
		UserDao userDao = new UserDao();
		boolean updateFlag = userDao.updateUser(username, email, createPassword, Integer.valueOf(id));
		if (updateFlag) {
			response.sendRedirect(request.getContextPath() + "/user/list");
		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		UserDao userDao = new UserDao();
		boolean deleteFlag = userDao.deleteUser(Integer.valueOf(id));
		if (logger.isInfoEnabled()) {
			logger.info("删除用户ID为{}的用户", id);
		}
		if (deleteFlag) {
			response.sendRedirect(request.getContextPath() + "/user/list");
		}
	}

	private void preUpdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer integer = Integer.valueOf(id);

		// 根据用户ID来查找该用户
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(integer);
		if (logger.isInfoEnabled()) {
			logger.info("查找出来的用户为：{}", user);
		}
		if (user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/userupdate.jsp").forward(request, response);
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 需要从页面获取当前页 如果是第一次进入查看的话 currentpage 是没有值的 设置默认值为第一页
		String currentPage = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1";

		PageService pageService = new PageService();
		PageBean pageBean = pageService.getPageBean(currentPage);

		request.setAttribute("pageUser", pageBean);
		request.getRequestDispatcher("/userlist.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
