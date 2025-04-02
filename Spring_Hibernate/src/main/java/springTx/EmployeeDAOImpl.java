package springTx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.management.RuntimeErrorException;

import springTx.*;

//import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	private DataSource dataSource;
	
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	
	private Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
		return dataSource.getConnection();
	}
	
	

	@Override
	public void save(Employee e) {
		
		
		new JdbcTemplate(dataSource).update("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)",e.getName(),e.getAge(),e.getGender().name(),e.getSalary(),e.getExp(),e.getLevel(),e.getId());

//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement
//					("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
//
//			setValuesToPrepareStatement(e, ps);
//			
//			
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows insterted" + rowsAffected);
//			
//			
//			
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
		
	}
	
	

	@Override
	public void update(Employee e) {
		
		new JdbcTemplate(dataSource).update("UPDATE EMPLOYEE SET NAME=?, AGE=?, GENDER=?,SALARY=?,EXPERIANCE=?,LEVEL=? WHERE ID=?");
		
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement
//					("UPDATE EMPLOYEE SET NAME=?, AGE=?, GENDER=?,SALARY=?,EXPERIANCE=?,LEVEL=? WHERE ID=?");
//		
//			setValuesToPrepareStatement(e, ps);
//			
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows insterted" + rowsAffected);
//			
//			
//		}catch(Exception ex){
//			throw new RuntimeException(ex);
//		}
	}



	private void setValuesToPrepareStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
	
		ps.setLong(7, e.getId());
		
	}

	
	
	@Override
	public Employee get(int id) {
		
		return new JdbcTemplate(dataSource).queryForObject("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE ID = ?",new Object[] {id}, new EmployeeRowMapper());
		
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//
//			//if this next return true when we have another row. and return false when we have end of resultset
//			if(rs.next()) {
//				
//				Employee e = populateEmployee(rs);
//				
//				return e;
//				
//			} else {
//				new RuntimeException("No id existis in db"+id);
//			}
//			
//			
//		}catch(Exception ex) {
//			
//			throw new RuntimeException(ex);
//		}
//		return null;
	}
	
	

	public static class EmployeeRowMapper implements RowMapper<Employee>{
	
		public Employee mapRow(ResultSet rs, int arg1)throws SQLException {
			return Employee.builder().id(rs.getLong(1))
					.name(rs.getString(2)).age(rs.getInt(3)).gender(springTx.Employee.Gender.valueOf(rs.getString(4)))
					.salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).build();
		}
	}
	
	

	private Employee populateEmployee(ResultSet rs) throws SQLException{
		
		Employee e = Employee.builder().id(rs.getLong(1))
				.name(rs.getString(2)).age(rs.getInt(3)).gender(springTx.Employee.Gender.valueOf(rs.getString(4)))
				.salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).build();
		return e;
	}



	@Override
	public List<Employee> getAll() {
		
		return new JdbcTemplate(dataSource).query("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE", new EmployeeRowMapper());
//		List<Employee> emps = new ArrayList<Employee>();
//		
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement
//					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE");
//
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//			
//				emps.add(populateEmployee(rs));
//			}
//			
//		}catch (Exception e) {
//			new RuntimeException(e);
//		}
//		
//		return emps;
		
	}
	
	@Override
	public void delete(int id) {
		
		new JdbcTemplate(dataSource).update("DELETE FROM EMPLOYEE WHERE ID=?");
		
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement
//					("DELETE FROM EMPLOYEE WHERE ID=?");
//		     ps.setInt(1, id);
//		
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows affected" + rowsAffected);
//			
//			
//		}catch(Exception ex){
//			throw new RuntimeException(ex);
//	}
	
	

}



	@Override
	public void sortByOrder(String s) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
