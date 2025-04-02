package servlets;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBConfigureListner
 *
 */
@WebListener
public class DBConfigureListner implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Properties dbproperties = new Properties();
		
		try {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties");
			
		if(inputStream != null) {
			
		
			dbproperties.load(inputStream);
		}else {
			System.out.println("DB file not found");
		} 
		
		sce.getServletContext().setAttribute("dbUrl", dbproperties.getProperty("db.url"));
		sce.getServletContext().setAttribute("dbUsername", dbproperties.getProperty("db.username"));
		sce.getServletContext().setAttribute("dbPassword", dbproperties.getProperty("db.password"));
		sce.getServletContext().setAttribute("dbDriver", dbproperties.getProperty("db.driver"));


		
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			System.out.println("Listner destroy called");
			//ServletContextListener.super.contextDestroyed(sce);
		}
	
    
	
}
