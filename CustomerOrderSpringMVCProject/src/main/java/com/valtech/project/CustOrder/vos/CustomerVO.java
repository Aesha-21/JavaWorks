package com.valtech.project.CustOrder.vos;

import com.valtech.project.CustOrder.model.Customer;
import com.valtech.project.CustOrder.model.Customer.customerStatus;

public record CustomerVO(Long custId, String custName,
		Integer age,String address,String perAdd, customerStatus customerStatus) {
	
	
	public static CustomerVO from(Customer cust) {
		
		return new CustomerVO(cust.getCustId(), cust.getCustName(), 
				cust.getAge(),cust.getAddress(), cust.getPerAdd(),cust.getCustomerStatus());
	}
	
	public Customer to() {
		Customer c =new Customer(custName, age, address, perAdd, customerStatus);
		c.setCustId(custId == null ? 0 :custId);
		return c;
	}
	
	public void updateTo(Customer cust) {
		cust.setCustName(custName);
		cust.setAge(age);
		cust.setAddress(address);
		cust.setPerAdd(perAdd);
		cust.setCustomerStatus(customerStatus);
	}

}
