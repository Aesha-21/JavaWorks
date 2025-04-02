package com.valtech.project.CustOrder.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_seq", allocationSize = 1)
	private long id;
	private String name;
	private String dis;
	private int currentQty;
	private int maxQty;
	private int reOrderQty;
	
	@OneToMany(mappedBy = "item",targetEntity = LineOrderItem.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL) //merge
	private List<LineOrderItem> lineOrderItem;

	public List<LineOrderItem> getLineOrderItem() {
		return lineOrderItem;
	}
	
	public void setLineOrderItem(List<LineOrderItem> lineOrderItem) {
		this.lineOrderItem = lineOrderItem;
	}
	
	
	public Item() {
	}

	public Item(String name, String dis, int currtQty, int reorderQty, int maxQty) {
		super();
		this.name = name;
		this.dis = dis;
		this.currentQty = currtQty;
		this.reOrderQty = reorderQty;
		this.maxQty = maxQty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDis() {
		return dis;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public int getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(int currtQty) {
		this.currentQty = currtQty;
	}

	public int getReOrderQty() {
		return reOrderQty;
	}

	public void setReOrderQty(int reorderQty) {
		this.reOrderQty = reorderQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

}
