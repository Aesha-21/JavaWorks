package servlets;
import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class DemoJdbc extends HttpServlet{
	
	
	public static Connection getConnection(ServletContext context) throws IOException, SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String dbUrl = (String) context.getAttribute("dbUrl");
        String dbUsername = (String) context.getAttribute("dbUsername");
        String dbPassword = (String) context.getAttribute("dbPassword");
        String dbDriver = (String) context.getAttribute("dbDriver");
        try {
			Connection conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			return conn;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException("Failed to connect");
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		
		try(Connection conn = getConnection(context)){
			
			resp.getWriter().print("DB connected");
			
			PreparedStatement pt = conn.prepareStatement("SELECT * FROM STUDENT");
			
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				resp.getWriter().print(rs.getInt(1));
				resp.getWriter().print(rs.getString(2));
				resp.getWriter().print(rs.getInt(3));

				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resp.getWriter().println("Error"+e.getMessage());
		}
		
		
		
		
		
	}
	
}
