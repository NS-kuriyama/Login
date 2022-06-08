package jp.co.aforce.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Beans;
import jp.co.aforce.dao.LoginDAO;

@WebServlet(urlPatterns = { "/jp.co.aforce/login" })
public class Login extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		LoginDAO dao = new LoginDAO();

		try {
			Beans b = dao.search(login, password);

			String username = b.getLogin();

			if (username != null) {
				request.setAttribute("beans", b);
				request.getRequestDispatcher("../jsp/login2.jsp").forward(request, response);

			} else {
				request.setAttribute("error", "IDまたはパスワードが間違っています");
				request.setAttribute("login", login);
				request.getRequestDispatcher("../jsp/login1.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
