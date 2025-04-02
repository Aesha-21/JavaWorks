package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	
	public static final String HOME_PAGE = "arithmetic.jsp";
	public static final String LOGIN_PAGE = "login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", "please enter username and password");
		req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		if("scott".equals(username) && "tiger".equals(password)) {
			//System.out.println("test");

			req.setAttribute("username", username);
			req.setAttribute("role", "User");
			req.getRequestDispatcher(HOME_PAGE).forward(req, resp);;
			 
		}else if("admin".equals(username) && "super".equals(password)) {
			
			req.setAttribute("username", username);
			req.setAttribute("role", "Admin,User");
			req.getRequestDispatcher(HOME_PAGE).forward(req, resp);;
			 
		}else {
			req.setAttribute("message", "Invalid username/password");
			req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);;

			
		}
	}

}
