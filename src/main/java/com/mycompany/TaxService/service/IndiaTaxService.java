package com.mycompany.TaxService.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("India")
@RefreshScope
public class IndiaTaxService implements TaxService {
	
	private final int CGST_PERCENT = 9;
	private final int SGST_PERCENT = 9;
	
	@Value("${com.test.prop2:ffssd}")
	private String propVal;
	
	@Autowired
	SpringProp springProp;
	
	@PostConstruct
	public void preIntitla() {
		System.out.println("Post construct in India Tax Service");
	}

	@Override
	public double calculateTax(double prodcutPrice) {
		double result = (prodcutPrice*(CGST_PERCENT + SGST_PERCENT) ) /100;
		System.out.print(propVal);
		//System.out.print(springProp.getProp(propVal));
		return result;
	}

}
