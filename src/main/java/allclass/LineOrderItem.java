package allclass;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LineOrderItem")
public class LineOrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineorderseq")
	@SequenceGenerator(name = "lineorderseq", sequenceName = "lineorder_seq", allocationSize = 1)
	private long id;

	private int qty;

	///---------------------------Order----------------------///
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Order.class)
	@JoinColumn(name="orderId",referencedColumnName = "id")
	private Order order;
	
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	///----------------------------Item-----------------------------///
	 
	@ManyToOne(targetEntity = Item.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="itemsId",referencedColumnName = "id")
	private Item items;
	
	public Item getItems() {
		return items;
	}
	
	public void setItems(Item items) {
		this.items = items;
	}
	
	
	///--------------------------------------------------------------///
	
	public LineOrderItem() {};
	
	public LineOrderItem(int qty) {
		super();
		
		
		this.qty = qty;
		
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id  + ", qty=" + qty + ", order_id=]";
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	

}
