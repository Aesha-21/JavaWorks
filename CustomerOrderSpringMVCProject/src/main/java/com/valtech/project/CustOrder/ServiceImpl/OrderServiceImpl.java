package com.valtech.project.CustOrder.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.CustOrder.model.Customer.customerStatus;
import com.valtech.project.CustOrder.model.LineOrderItem;
import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.model.OrderTable.orderStatus;
import com.valtech.project.CustOrder.repos.CustomerRepo;
import com.valtech.project.CustOrder.repos.OrderRepo;
import com.valtech.project.CustOrder.service.CustomerService;
import com.valtech.project.CustOrder.service.ItemService;
import com.valtech.project.CustOrder.service.OrderService;
import com.valtech.project.CustOrder.vos.ItemVO;
import com.valtech.project.CustOrder.vos.OrderVO;
import com.valtech.project.CustOrder.vos.AddToCartVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public void placeOrder(AddToCartVO pvo) {

		// custid,itmid,qty
		Long custId = pvo.custId();
		Long itemId = pvo.itemId();
		int qty = pvo.qty();
		System.out.println("Place Order = " + pvo);

		LineOrderItem loi = new LineOrderItem();
		System.out.println("before itm id"+itemId);
		loi.setItem(itemService.getItem(itemId).to());
		System.out.println("after itm id"+itemId);

		loi.setQty(qty);

		OrderTable order = new OrderTable();
		order.addLineOrderItem(loi);
		System.out.println("Customer = "+customerRepo.getReferenceById(custId));
		order.setCustomer(customerRepo.getReferenceById(custId));
		order.setOrderStatus(orderStatus.PROCESSING);
//		boolean flag = true;

		for (LineOrderItem lineorderitem : order.getLineOrderItem()) {
			
			if (lineorderitem.getQty() > lineorderitem.getItem().getCurrentQty()) {
				System.out.println("place order for llop");
//				flag = false;
				order.setOrderStatus(orderStatus.CANCELED);
				orderRepo.save(order);
				System.out.println("Customer is Disable and Quantity is unavailable");
				break;
			} else {
				System.out.println("this is else condi which is true");
				order.setOrderStatus(orderStatus.DISPACHED); // dispatch
				System.out.println("before order save "+order);
				
				orderRepo.saveAndFlush(order);
				System.out.println("after order save");
				itemService.updateInventory(order);
				System.out.println("update sucess...");


			}
		
		
		}

	}
	
//	@Override
//	public OrderVO saveOrder(AddToCartVO pvo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void save(AddToCartVO orderVO) {
//		orderRepo.save(orderVO);
//		
//	}

	

//	@Override
//	public OrderVO saveOrder(AddToCartVO orderVO) {
//		orderRepo.save(orderVO);
//		OrderTable ordertbl = orderVO.to();
//		ordertbl.orderRepo.save(ordertbl);
//		ordertbl = orderRepo.save(ordertbl);
//		return OrderVO.from(ordertbl);
//		return null;
//	}

}
