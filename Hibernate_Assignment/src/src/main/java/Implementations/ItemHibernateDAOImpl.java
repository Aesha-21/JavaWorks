package Implementations;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import allclass.Item;
import dao.IteamDAO;

public class ItemHibernateDAOImpl implements IteamDAO{

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void add(Item itm) {
		new HibernateTemplate(sessionFactory).save(itm);
		
	}

	@Override
	public void update(Item itm) {
		new HibernateTemplate(sessionFactory).update(itm);
		
		
	}

	@Override
	public void delete(Item itm) {
		new HibernateTemplate(sessionFactory).delete(itm);
		
	}
	@Override
	public void get(String name) {
		new HibernateTemplate(sessionFactory).load(Item.class,name);
		
	}
	@Override
	public Item get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
