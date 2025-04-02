package com.valtech.project.CustOrder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valtech.project.CustOrder.service.ItemService;
import com.valtech.project.CustOrder.vos.ItemVO;

@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/item")
	public String showItem() {
		return "item";
	}
	
	@RequestMapping(path = "item", method = RequestMethod.POST)
//	@RequestMapping(path = "/item", method = RequestMethod.POST)

	public String itemForm(@ModelAttribute("ivo") ItemVO ivo,Model model)
	{
		this.itemService.saveItem(ivo);
		model.addAttribute("ivo",itemService.getAllItems());
		return "item";
	}

}
