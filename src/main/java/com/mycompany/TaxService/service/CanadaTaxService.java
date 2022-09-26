package com.mycompany.TaxService.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Canada")
public class CanadaTaxService implements TaxService{
	
	private final int TAX_PERCENT = 20;

	@Override
	public double calculateTax(double prodcutPrice) {
		return (prodcutPrice*TAX_PERCENT)/100;
	}

}
