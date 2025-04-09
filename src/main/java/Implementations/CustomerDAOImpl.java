package Implementations;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import allclass.Customer;
import dao.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO{

	private DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
//	private SessionFactory sessionFactory;
	
//	private Connection getConnection() throws SQLException{
//		return datasource.getConnection();
//	}
	
//	@Override
//	public void save(Customer c) {
//		new JdbcTemplate(datasource).update("INSERT INTO CUSTOMER (CUST_NAME,AGE,ADDRESS,PER_ADD,ID) VALUES(?,?,?,?,?)",
//				c.getCust_name(),c.getAge(),c.getAddress(),c.getPer_add(),c.getId());
//	}

	@Override
	public void add(Customer c) {
		
//		sessionFactory.getCurrentSession().save(c);
		new JdbcTemplate(datasource).update("INSERT INTO CUSTOMER (CUST_NAME,AGE,ADDRESS,PER_ADD,ID) VALUES(?,?,?,?,?)",
				c.getCustname(),c.getAge(),c.getAddress(),c.getPerAdd(),c.getCustId());
	
		
	}

	@Override
	public void update(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
