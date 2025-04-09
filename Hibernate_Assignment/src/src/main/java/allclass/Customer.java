package allclass;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "allcustomer")
public class Customer {

	public enum customerStatus{
		DISABLE,ENABLE
	};
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custseq")
	@SequenceGenerator(name = "custseq", sequenceName = "cust_req", allocationSize = 1)
	private long custId;
	private String custname;
	private int age;
	private String address;
	private String perAdd;
	@Enumerated(EnumType.STRING)
	private customerStatus customerStatus;
	

	/// --------------------------Order------------------------------///

	
	@OneToMany(targetEntity = Order.class, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> order;

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}


	public Customer() {}

	public Customer(String custName, int age, String address, String perAdd,allclass.Customer.customerStatus customerStatus) {
		super();
		
		this.custname = custName;
		this.age = age;
		this.address = address;
		this.perAdd = perAdd;
		this.customerStatus = customerStatus;
		
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custname=" + custname + ", age=" + age + ", address=" + address
				+ ", perAdd=" + perAdd + "]";
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custName) {
		this.custname = custName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerAdd() {
		return perAdd;
	}

	public void setPerAdd(String perAdd) {
		this.perAdd = perAdd;
	}
	
	public customerStatus getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(customerStatus customerStatus) {
		this.customerStatus = customerStatus;
	}


}
