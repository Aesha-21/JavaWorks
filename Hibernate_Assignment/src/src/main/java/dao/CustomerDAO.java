package dao;

import java.util.List;

import allclass.Customer;

public interface CustomerDAO {

	void add(Customer c);
	void update(Customer c);
	void delete(Customer c);
	Customer get(int id);
	List<Customer> getAll();
	
}
