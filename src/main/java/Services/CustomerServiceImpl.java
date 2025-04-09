package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import allclass.Customer;
import dao.CustomerDAO;
import dao.CustomerService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO custDAO;
	
	public void setCustDAO(CustomerDAO custDAO) {
		this.custDAO = custDAO;
	}

	@Override
	@Transactional
	public void add(Customer c) {
		custDAO.add(c);
		
		
	}

	@Override
	public void update(Customer c) {
		custDAO.update(c);
		
	}

	@Override
	public void delete(Customer c) {
		custDAO.delete(c);
		
	}

	@Override
	public Customer get(int id) {
		
		return custDAO.get(id);
	}

	@Override
	public List<Customer> getAll() {
		
		return custDAO.getAll();
	}

	
	
	

}
