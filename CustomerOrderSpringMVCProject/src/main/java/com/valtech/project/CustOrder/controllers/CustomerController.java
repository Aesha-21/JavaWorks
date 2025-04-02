package com.valtech.project.CustOrder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.project.CustOrder.model.Customer;
import com.valtech.project.CustOrder.service.CustomerService;
import com.valtech.project.CustOrder.vos.CustomerVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public String customer(HttpServletRequest req) {
		return "customer";//web-inf/jsps/customer.jsp
	}
//	
//	@RequestMapping(path = "/customerForm", method = RequestMethod.POST)
//	public String addCustomer(@RequestParam("name") String name, Model model) {
//		System.out.println(name);
//		
//		model.addAttribute("name",name);
//		return "customer";
//	}
	
	@RequestMapping(path = "customer",method = RequestMethod.POST)
	public String allCustomerForm(@ModelAttribute("cvo") CustomerVO cvo, Model model) {
		System.out.println(cvo);
		customerService.saveCustomer(cvo);
		model.addAttribute("cvo",customerService.getAllCustomers());
		return "customer";
	}
	

}
