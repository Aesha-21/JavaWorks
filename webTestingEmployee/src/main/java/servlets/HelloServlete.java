package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlete extends HttpServlet {
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		String company = getInitParameter("Company");
		System.out.println("Init method called..."+company);
	}
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respose) 
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println("Service...");
		
		PrintWriter out = respose.getWriter();
		out.println("Hello Servlets"+name);
		
	
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy...");
	}

}
