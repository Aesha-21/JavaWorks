package AssignmentEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.management.RuntimeErrorException;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import AssignmentEmployee.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgres");
	}
	
	

	@Override
	public void save(Employee e) {

		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
//			
//			ps.setString(1, e.getName());
//			ps.setInt(2, e.getAge());
//			ps.setString(3, e.getGender().name());
//			ps.setFloat(4, e.getSalary());
//			ps.setInt(5, e.getExp());
//			ps.setInt(6, e.getLevel());
//			ps.setLong(7, e.getId());
			
			setValuesToPrepareStatement(e, ps);
			
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows insterted" + rowsAffected);
			
			
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	

	@Override
	public void update(Employee e) {
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("UPDATE EMPLOYEE SET NAME=?, AGE=?, GENDER=?,SALARY=?,EXPERIANCE=?,LEVEL=? WHERE ID=?");
		
			setValuesToPrepareStatement(e, ps);
			
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows insterted" + rowsAffected);
			
			
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
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
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			//if this next return true when we have another row. and return false when we have end of resultset
			if(rs.next()) {
				
				Employee e = populateEmployee(rs);
				
				return e;
				
			} else {
				new RuntimeException("No id existis in db"+id);
			}
			
			
		}catch(Exception ex) {
			
			throw new RuntimeException(ex);
		}
		return null;
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException{
		
		Employee e = Employee.builder().id(rs.getLong(1))
				.name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4)))
				.salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).build();
		return e;
	}



	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<Employee>();
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE");

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			
				emps.add(populateEmployee(rs));
			}
			
		}catch (Exception e) {
			new RuntimeException(e);
		}
		
		return emps;
		
	}
	
	@Override
	public void delete(int id) {
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("DELETE FROM EMPLOYEE WHERE ID=?");
		     ps.setInt(1, id);
		
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows affected" + rowsAffected);
			
			
		}catch(Exception ex){
			throw new RuntimeException(ex);
	}
	
	

}
	}
