package com.valtech.project.CustOrder.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class OrderTable {
	
	public enum orderStatus {
		DELIVERED, CANCELED, PROCESSING,DISPACHED,PENDING;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_req", allocationSize = 1)

	private long id;
	@Enumerated(EnumType.STRING)
	private orderStatus orderStatus;
	
	
	///-------------------------------lineorderitem--------------------------///

	@OneToMany(mappedBy = "order" , targetEntity = LineOrderItem.class,fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<LineOrderItem> lineOrderItem;
	
	public List<LineOrderItem> getLineOrderItem() {
		return lineOrderItem;
	}
	
	public void setLineOrderItem(List<LineOrderItem> lineOrderItem) {
		this.lineOrderItem = lineOrderItem;
	}
	
	public void addLineOrderItem(LineOrderItem loi) {
		if(lineOrderItem == null ) lineOrderItem = new ArrayList<LineOrderItem>();
		lineOrderItem.add(loi);
		loi.setOrder(this);
	}
	
	public void removeLineOrderItem(LineOrderItem loi) {
		lineOrderItem.remove(loi);
		loi.setOrder(this);
	}
	
	
	///-------------------------------Customer----------------------------------///
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Customer.class) //merge
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	///-----------------------------------------------------------------///

	
	public OrderTable() {}
	

	@Override
	public String toString() {
		return "OrderTable [id=" + id + ", orderStatus=" + orderStatus 
				+ ", customer=" + customer.getCustId() + "]";
	}

	public OrderTable(OrderTable.orderStatus orderStatus) {
		super();
		this.orderStatus = orderStatus;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public orderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(orderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	

}
