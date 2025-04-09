package allclass;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_req", allocationSize = 1)
	private long id;
	private String name;
	private String dis;
	private int currtQty;
	private int reorderQty;
	private int maxQty;
	
	@OneToMany(mappedBy = "items",targetEntity = LineOrderItem.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<LineOrderItem> lineOrderItem;
	
	public Set<LineOrderItem> getLineOrderItem() {
		return lineOrderItem;
	}
	
	public void setLineOrderItem(Set<LineOrderItem> lineorderitem) {
		this.lineOrderItem = lineorderitem;
	}
	
	
	
	public Item() {}
	
	
	
	public Item( String name, String dis, int currtQty, int reorderQty, int maxQty) {
		super();
		
		this.name = name;
		this.dis = dis;
		this.currtQty = currtQty;
		this.reorderQty = reorderQty;
		this.maxQty = maxQty;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", dis=" + dis + ", currtQty=" + currtQty + ", reorder_qty="
				+ reorderQty + ", max_qty=" + maxQty + "]";
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
	public void setDis(String desc) {
		this.dis = desc;
	}
	public int getCurrtQty() {
		return currtQty;
	}
	public void setCurrtQty(int currtQty) {
		this.currtQty = currtQty;
	}
	public int getReorderQty() {
		return reorderQty;
	}
	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}
	public int getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}
	
	
}
