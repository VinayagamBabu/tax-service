package com.mycompany.TaxService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.TaxService.service.TaxService;

@Controller
public class TaxController {
	
	@Autowired //Setter Injection
	TaxService indiaTaxService;
	
	@RequestMapping("/getTax")
	@ResponseBody
	public double getTax( @RequestParam("price") double price) {
		return indiaTaxService.calculateTax(price);
	}
	
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable("name") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
