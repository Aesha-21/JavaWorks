package com.valtech.project.CustOrder.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.project.CustOrder.model.Customer;
import com.valtech.project.CustOrder.repos.CustomerRepo;
import com.valtech.project.CustOrder.service.CustomerService;
import com.valtech.project.CustOrder.vos.CustomerVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public CustomerVO getCustomer(long id) {
		Customer cust = customerRepo.getReferenceById(id);
		return CustomerVO.from(cust);
	}

	@Override
	public List<CustomerVO> getAllCustomers() {
		return customerRepo.findAll().stream().map(c -> CustomerVO.from(c)).collect(Collectors.toList());
	}
	@Override
	public CustomerVO saveCustomer(CustomerVO cvo) {
		Customer cust = cvo.to();
		cust = customerRepo.save(cust);
		return CustomerVO.from(cust);
	}

	

}
