package com.valtech.project.CustOrder.vos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.model.OrderTable.orderStatus;

public record OrderVO(Long id, orderStatus orderStatus) {
	
	public static OrderVO from(OrderTable ord) {
		return new OrderVO(ord.getId(), ord.getOrderStatus());
	}
	
	
	public OrderTable to() {
		return new OrderTable(orderStatus);
	}

}
