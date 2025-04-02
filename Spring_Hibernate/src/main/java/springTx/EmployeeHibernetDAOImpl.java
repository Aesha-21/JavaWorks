package springTx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeHibernetDAOImpl implements EmployeeDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Employee e) {
		
		new HibernateTemplate(sessionFactory).save(e);
	}

	@Override
	public void update(Employee e) {
		new HibernateTemplate(sessionFactory).update(e.getId());
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
		
	}

	@Override
	public List<Employee> getAll() {
		
		return new HibernateTemplate(sessionFactory).find("From Employee e");
	}

	@Override
	public Employee get(int id) {
		
		return new HibernateTemplate(sessionFactory).load(Employee.class, id);
	}

	@Override
	public void sortByOrder(String s) {
		// TODO Auto-generated method stub
		
	}

}
