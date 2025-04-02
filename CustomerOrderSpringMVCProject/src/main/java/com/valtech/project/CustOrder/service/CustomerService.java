package com.valtech.project.CustOrder.service;

import java.util.List;

import com.valtech.project.CustOrder.vos.CustomerVO;

public interface CustomerService {

	CustomerVO saveCustomer(CustomerVO cvo);
	CustomerVO getCustomer(long id);
	List<CustomerVO> getAllCustomers();
}
