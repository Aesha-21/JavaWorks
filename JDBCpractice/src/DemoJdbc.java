import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DemoJdbc {
	
	
	public static Connection getConnection() throws IOException, SQLException {
		Properties properties = new Properties();
		
		FileInputStream inputStream = new FileInputStream("src/db.properties");
		properties.load(inputStream);
		
		
		String dbUrl = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");
        
        try {
			Connection conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			return conn;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException("Failed to connect");
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		
			Connection conn = getConnection();
			System.out.println("Connected");
			
		
		
		
//		Class.forName("org.postgresql.Driver");
//		
//		Connection con = DriverManager.getConnection("db.url");
//		
//		System.out.println("Conncted....");
//		
		PreparedStatement pt = conn.prepareStatement("SELECT * FROM STUDENT");
		
		ResultSet rs = pt.executeQuery();
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));

			
//		String nm = rs.getString("sname");
//		System.out.println(nm);
		}
		conn.close();
		
	}
	
}
