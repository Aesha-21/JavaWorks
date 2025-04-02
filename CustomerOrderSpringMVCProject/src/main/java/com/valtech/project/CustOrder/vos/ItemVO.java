package com.valtech.project.CustOrder.vos;

import com.valtech.project.CustOrder.model.Item;

public record ItemVO(Long id, String name,String dis,Integer currentQty,Integer reOrderQty,Integer maxQty ) {

	public static ItemVO from(Item itm) {
		
		return new ItemVO(itm.getId(), itm.getName(), itm.getDis(),
				itm.getCurrentQty(), itm.getMaxQty(), itm.getReOrderQty());
	}
	
	public Item to() {
		return new Item(name, dis, currentQty, maxQty, reOrderQty);
	}
	
	public void updateTo(Item itm) {
		itm.setName(name);
		itm.setCurrentQty(currentQty);
		itm.setDis(dis);
		itm.setMaxQty(maxQty);
		itm.setReOrderQty(reOrderQty);
	}
}
