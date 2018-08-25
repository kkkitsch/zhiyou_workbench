package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckNameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginName = request.getParameter("loginName");
		if ("admin".equals(loginName)) {
			request.setAttribute("data", false);
			request.getRequestDispatcher("data.jsp").forward(request, response);
			return;
		}
		request.setAttribute("data", true);
		request.getRequestDispatcher("data.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
