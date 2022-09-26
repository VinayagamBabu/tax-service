package com.mycompany.TaxService.service;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("India")
public class IndiaTaxService implements TaxService {
	
	private final int CGST_PERCENT = 9;
	private final int SGST_PERCENT = 9;
	
	@PostConstruct
	public void preIntitla() {
		System.out.println("Post construct in India Tax Service");
	}

	@Override
	public double calculateTax(double prodcutPrice) {
		double result = (prodcutPrice*(CGST_PERCENT + SGST_PERCENT) ) /100;
		return result;
	}

}
