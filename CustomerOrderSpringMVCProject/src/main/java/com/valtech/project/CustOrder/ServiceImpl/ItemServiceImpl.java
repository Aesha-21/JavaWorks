package com.valtech.project.CustOrder.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.CustOrder.model.Item;
import com.valtech.project.CustOrder.model.LineOrderItem;
import com.valtech.project.CustOrder.model.OrderTable;
import com.valtech.project.CustOrder.repos.ItemRepo;
import com.valtech.project.CustOrder.service.ItemService;
import com.valtech.project.CustOrder.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepo itemRepo;
	
	ItemVO itemVO;

	@Override
	public ItemVO getItem(long id) {
		Item itm = itemRepo.getReferenceById(id);
		return ItemVO.from(itm);
	}

	@Override
	public List<ItemVO> getAllItems() {
		return itemRepo.findAll().stream().map(i -> ItemVO.from(i)).collect(Collectors.toList());
	}

	@Override
	public ItemVO saveItem(ItemVO ivo) {
		Item itm = ivo.to();
		itm = itemRepo.save(itm);
		return ItemVO.from(itm);
	}

	@Override
	public void updateInventory(OrderTable order) {

		Item item;
		for(LineOrderItem lineorder: order.getLineOrderItem()) {
			item = itemRepo.getReferenceById(lineorder.getItem().getId());
			item.setCurrentQty(item.getCurrentQty() - lineorder.getQty());
			item.setReOrderQty(item.getReOrderQty() + lineorder.getQty());
			itemRepo.save(item);
//			itemVO.updateTo(item); 
			
			if(item.getCurrentQty() == 0 ) {
				item.setCurrentQty(item.getMaxQty());
				item.setReOrderQty(0);
				itemRepo.save(item);
//				itemVO.updateTo(item);
			}
		}
		
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
