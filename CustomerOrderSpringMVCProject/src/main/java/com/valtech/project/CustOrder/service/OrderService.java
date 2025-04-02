package com.valtech.project.CustOrder.service;

import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.vos.OrderVO;
import com.valtech.project.CustOrder.vos.AddToCartVO;

public interface OrderService {

	void placeOrder(AddToCartVO pvo);
//	OrderVO saveOrder(AddToCartVO pvo);
//	void save(AddToCartVO orderVO);
}
