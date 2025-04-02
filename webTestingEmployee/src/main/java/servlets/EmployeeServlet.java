package servlets;
import java.io.IOException;
import java.util.Comparator;

import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
			
		dao = new EmployeeDAOImpl();
	
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("operation");
		
		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("emps", e);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editemployee.jsp").forward(req, resp);
			return;
		}
		
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps",dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);

			
		}
		
		
		if("newEmp".equals(operation)) {
		
			req.setAttribute("mode", "Save");

			req.getRequestDispatcher("editemployee.jsp").forward(req, resp);
			return ;
			
		}
		
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if("cancel".equals(operation)) {
			
		req.setAttribute("emps",dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
		return;

		}
		Employee emp = Employee.builder().id(Integer.parseInt(req.getParameter("id"))).
				name(req.getParameter("name")).
				age(Integer.parseInt(req.getParameter("age"))).
				gender(Gender.valueOf(req.getParameter("gender").toUpperCase())).
				salary(Float.parseFloat(req.getParameter("salary"))).
				exp(Integer.parseInt(req.getParameter("experiance"))).
				level(Integer.parseInt(req.getParameter("level"))).build();
		
		
		
		if("Save".equals(operation)) {
			
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);

			return;
			
		}
		
		if("Update".equals(operation)) {
			
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);

			return;
			
		}
		
		
		

	}

}
