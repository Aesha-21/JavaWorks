package allclass;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Orders")
public class Order {

	public enum orderStatus {
		DELIVERED, CANCELED, PROCESSING,SHIPPED,PENDING;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_req", allocationSize = 1)
	private long id;
    @Enumerated(EnumType.STRING)
	private orderStatus orderStatus;

	/// --------------------------LineOrderItem--------------------///
	@OneToMany(mappedBy = "order", targetEntity = LineOrderItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<LineOrderItem> lineorderitem;

	public Set<LineOrderItem> getLineorderitem() {
		return lineorderitem;
	}

	public void setLineorderitem(Set<LineOrderItem> lineorderitem) {
		this.lineorderitem = lineorderitem;
	}

	/// -------------------------Customer--------------------///

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Customer.class)
	@JoinColumn(name = "custId", referencedColumnName = "custId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/// -----------------------Orders----------------------///
	public Order() {}

	public Order(orderStatus orderStatus) {
		super();

		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "orderStatus=" + orderStatus + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public orderStatus getOrder_status() {
		return orderStatus;
	}

	public void setOrder_status(orderStatus order_status) {
		this.orderStatus = order_status;
	}

}
