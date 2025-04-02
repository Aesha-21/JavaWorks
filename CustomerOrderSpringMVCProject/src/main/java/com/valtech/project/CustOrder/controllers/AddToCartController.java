package com.valtech.project.CustOrder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.project.CustOrder.service.OrderService;
import com.valtech.project.CustOrder.vos.AddToCartVO;

@Controller
public class AddToCartController {
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping("/placeOrder")
	public String placeOrder() {
		return "placeOrder";
	}
	
	@RequestMapping(path = "/placeOrder" , method = RequestMethod.POST)
	public String addOrders(@ModelAttribute("pvo") AddToCartVO pvo, Model model) {
		orderService.placeOrder(pvo);
		return "placeOrder";
	}

}
