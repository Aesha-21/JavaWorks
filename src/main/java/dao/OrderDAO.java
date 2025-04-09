package dao;

import java.util.List;

import allclass.Order;

public interface OrderDAO {
	
	void save(Order o);
	void update(Order o);
	void delete(Order o);
	Order get(int id);
	List<Order> getAll();

}
