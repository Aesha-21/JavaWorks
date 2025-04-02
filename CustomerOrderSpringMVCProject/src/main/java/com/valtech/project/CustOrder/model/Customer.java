package com.valtech.project.CustOrder.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Customer {

	public enum customerStatus{
		DISABLE,ENABLE
	};
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custseq")
	@SequenceGenerator(name = "custseq", sequenceName = "cust_seq", allocationSize = 1)
	private long custId;
	private String custName;
	private int age;
	private String address;
	private String perAdd;
	@Enumerated(EnumType.STRING)
	private customerStatus customerStatus;
	
	
	///------------------------------Order----------------------------///
	
	@OneToMany(targetEntity = OrderTable.class, fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.MERGE)
	private Set<OrderTable> order;
	
	public Set<OrderTable> getOrder() {
		return order;
	}
	
	public void setOrder(Set<OrderTable> order) {
		this.order = order;
	}
	
	///---------------------------------------------------------------///

	public Customer() {}
	
	public Customer(String custName, int age, String address, String perAdd,
			customerStatus customerStatus) {
		super();
		this.custName = custName;
		this.age = age;
		this.address = address;
		this.perAdd = perAdd;
		this.customerStatus = customerStatus.ENABLE;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", age=" + age + ", address=" + address
				+ ", perAdd=" + perAdd + ", customerStatus=" + customerStatus + "]";
	}




	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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
