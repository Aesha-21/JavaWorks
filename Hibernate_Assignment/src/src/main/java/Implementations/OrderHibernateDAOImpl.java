package Implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import allclass.Order;
import dao.OrderDAO;

public class OrderHibernateDAOImpl implements OrderDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Order o) {
		new HibernateTemplate(sessionFactory).save(o);
		
	}

	@Override
	public void update(Order o) {
		new HibernateTemplate(sessionFactory).update(o);
		
	}

	@Override
	public void delete(Order o) {
		new HibernateTemplate(sessionFactory).delete(o);
		
	}
	@Override
	public Order get(int id) {
		
		return new HibernateTemplate(sessionFactory).load(Order.class, id);
	}
	@Override
	public List<Order> getAll() {
		
		return new HibernateTemplate(sessionFactory).find("From Order o");
	}

}
