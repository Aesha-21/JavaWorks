package testclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Implementations.CustomerDAOImpl;
import allclass.Customer;
import allclass.Customer.customerStatus;
import allclass.Item;
import allclass.LineOrderItem;
import allclass.Order;
import allclass.Order.orderStatus;
import dao.CustomerService;
import dao.*;

public class TestCustomer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cust-order.xml");
//		System.out.println(cs.getClass().getName());

		/// -------------Customer------------///
		CustomerService cs = ctx.getBean(CustomerService.class);
//		
//		cs.add(new Customer("Aesha",22,"Baroda","Mg Road"));

//	    Customer cust = new Customer("Heta",25,"Pune","MG Road");
//	    cust.setCust_id(2);
//		cs.update(cust);
		CustomerDAO customerDAO = new CustomerDAOImpl() ;
//		Customer customer;
		assertEquals("aesha",customerDAO.get(1).getCustname());

		/// ------------Order----------------///
		// Add order in table
//		Order o = new Order("Speaker", orderStatus.PENDING);
//
//		OrderDAO od = ctx.getBean(OrderDAO.class);
//		od.add(new Order("Order 1", orderStatus.PROCESSING)); //not use now
//		o.setCustomer(cust);
//		od.add(o);

		// add order along with cust id

//		Customer cust = new Customer("Heta",25,"Pune","Mira road");

//		o.setCustomer(cust);
//		od.add((Order) ord);
//		cs.update(cust);

		/// -----------Item----------------///
//		Item i = new Item("Speaker", "Boat Speaker", 5, 2, 15);
//		
//		IteamDAO itm = ctx.getBean(IteamDAO.class);
//		itm.add(i);

		/// ------------LineOrderItem----------///
//		LineOrderItem lti = new LineOrderItem(20);
//		lti.setOrder(o);
//		lti.setItems(i);
//		LineOrderItemDAO lio = ctx.getBean(LineOrderItemDAO.class);
//
//		lio.add(lti);

//		lio.add(new LineOrderItem(1L, 23));
		
		///----------------------------USE THIS---------------------------------///

//		Customer cust = new Customer("Veer", 26, "GIFT", "GIFT City Road",customerStatus.ENABLE);
//		Order o = new Order(orderStatus.DELIVERED);
//
//		OrderDAO od = ctx.getBean(OrderDAO.class);
//		o.setCustomer(cust);
//		od.save(o);
//		Item i = new Item("Laptop Bag", "Dynatrack laptop Bag", 5, 20, 5);
//
//		LineOrderItem lti = new LineOrderItem(5);
//		lti.setOrder(o);
//		lti.setItems(i);
//		LineOrderItemDAO lio = ctx.getBean(LineOrderItemDAO.class);
//
//		lio.add(lti);
//		
//		
//		
//
//		ctx.close();

	}

}
