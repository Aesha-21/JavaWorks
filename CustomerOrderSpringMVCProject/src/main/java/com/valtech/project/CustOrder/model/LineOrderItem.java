package com.valtech.project.CustOrder.model;
import jakarta.persistence.*;

@Entity
public class LineOrderItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineorderseq")
	@SequenceGenerator(name = "lineorderseq", sequenceName = "lineorder_seq", allocationSize = 1)
	private long id;
	private int qty;
	
	
	///--------------------------Order----------------------///
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = OrderTable.class)
	@JoinColumn(name="orderId", referencedColumnName = "id")
	private OrderTable order;
	
	public OrderTable getOrder() {
		return order;
	}
	
	public void setOrder(OrderTable order) {
		this.order = order;
	}
	
	///---------------------------Item----------------------///
	
	@ManyToOne(targetEntity = Item.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL) 
	@JoinColumn(name="itemsId",referencedColumnName = "id")
	private Item item;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	///------------------------------------------------------///
	
	public LineOrderItem() {}

	
	public LineOrderItem(int qty) {
		super();
		this.qty = qty;
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
