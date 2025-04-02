package com.valtech.project.CustOrder.service;

import java.util.List;

import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.vos.ItemVO;

public interface ItemService {

	ItemVO getItem(long id);
	List<ItemVO> getAllItems();
	ItemVO saveItem(ItemVO ivo);
	
	void updateInventory(OrderTable order);
	
}
