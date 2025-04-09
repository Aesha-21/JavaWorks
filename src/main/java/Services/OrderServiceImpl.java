package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import allclass.Customer;
import allclass.Customer.customerStatus;
import allclass.Item;
import allclass.LineOrderItem;
import allclass.Order;
import allclass.Order.orderStatus;
import dao.CustomerDAO;
import dao.IteamDAO;
import dao.IteamService;
import dao.LineOrderItemDAO;
import dao.OrderDAO;
import dao.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private LineOrderItemDAO loiDao;
	@Autowired
	private IteamDAO itemDao;
	private CustomerDAO customerDao;
	private IteamService itemService;

	public void setOrderDAO(OrderDAO orderDAO) {
//		
	}

	@Override
	public void placeOrder(Order order) {

		Item item;
		for (LineOrderItem lineorder : order.getLineorderitem()) {

			item = itemDao.get(lineorder.getItems().getId());

			Customer cust = new Customer();
			if (cust.getCustomerStatus() == Customer.customerStatus.DISABLE) {
				System.out.println("Your Customer profile is on Disable Stat");

			} else if (lineorder.getQty() > item.getMaxQty()) {
				order.setOrder_status(orderStatus.CANCELED);
			}

			else if (lineorder.getQty() > item.getCurrtQty()) {
				if (lineorder.getQty() == item.getCurrtQty()) {
					order.setOrder_status(orderStatus.PENDING);
				}
				orderDAO.save(order);
				
			} else {
				order.setOrder_status(orderStatus.PROCESSING);
				System.out.println("Yor order in Processing...");
				itemService.updateItems(order);
			}
		}

	}

	
}
