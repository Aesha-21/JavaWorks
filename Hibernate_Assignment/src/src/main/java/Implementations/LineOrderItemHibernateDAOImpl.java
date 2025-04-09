package Implementations;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import allclass.LineOrderItem;
import dao.LineOrderItemDAO;

public class LineOrderItemHibernateDAOImpl implements LineOrderItemDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void add(LineOrderItem orditm) {
		new HibernateTemplate(sessionFactory).save(orditm);
		
	}

	@Override
	public void update(LineOrderItem orditm) {
		new HibernateTemplate(sessionFactory).update(orditm);;
		
	}

	@Override
	public void delete(LineOrderItem orditm) {
		new HibernateTemplate(sessionFactory).delete(orditm);
		
	}

}
