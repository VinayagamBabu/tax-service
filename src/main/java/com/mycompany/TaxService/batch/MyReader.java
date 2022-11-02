package com.mycompany.TaxService.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyReader implements ItemReader<String>{
	
	private String[] transactions = { "Txn123435;1111111;2222222;500.00",
			"Txn123436;1111111;3333333;200.00",
			"Txn123437;1111111;2222222;300.00" };
	private int count = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(count < transactions.length) {
			return transactions[count++];
		}else {
			count =0;
		}
		return null;
	}

}
