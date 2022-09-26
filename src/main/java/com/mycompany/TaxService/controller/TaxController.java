package com.mycompany.TaxService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.TaxService.service.TaxService;

@RestController
public class TaxController {
	
	@Autowired //Setter Injection
	TaxService indiaTaxService;
	
	/*@Autowired
	public TaxController(TaxService taxService) {
		this.taxService = taxService;
	} */
	
	@RequestMapping("/getTax")
	public double getTax(@RequestParam("price") double price) {
		return indiaTaxService.calculateTax(price);
	}

}
