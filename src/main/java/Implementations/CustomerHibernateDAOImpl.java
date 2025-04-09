package Implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import allclass.Customer;
import dao.CustomerDAO;

public class CustomerHibernateDAOImpl implements CustomerDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void add(Customer c) {
		new HibernateTemplate(sessionFactory).save(c);
		
	}

	@Override
	public void update(Customer c) {
		new HibernateTemplate(sessionFactory).update(c);
		
	}

	@Override
	public void delete(Customer c) {
		new HibernateTemplate(sessionFactory).delete(c);
		
	}

	@Override
	public Customer get(int id) {
		
		return new HibernateTemplate(sessionFactory).load(Customer.class, id);
	}

	@Override
	public List<Customer> getAll() {
		
		return new HibernateTemplate(sessionFactory).find("From Customer c");
	}

}
