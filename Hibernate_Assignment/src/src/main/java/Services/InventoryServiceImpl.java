package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allclass.Item;
import allclass.LineOrderItem;
import allclass.Order;
import dao.IteamDAO;
import dao.IteamService;
import dao.LineOrderItemDAO;
import dao.OrderDAO;

@Service
public class InventoryServiceImpl implements IteamService {

	@Autowired
	private IteamDAO itemDao;

	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private LineOrderItemDAO lineOrderDao;

	@Override
	public void updateItems(Order order) {
		
		Item item;
		for (LineOrderItem lineorder : order.getLineorderitem()) {
			item = itemDao.get(lineorder.getItems().getId());
			item.setCurrtQty(item.getCurrtQty()-lineorder.getQty());
			item.setReorderQty(item.getReorderQty()+lineorder.getQty());
			itemDao.update(item);
			if(item.getCurrtQty()==0) {
				item.setCurrtQty(item.getMaxQty());
				item.setReorderQty(0);
				itemDao.update(item);
//			itemDao.add(item);
			}
		}
	}

}
