package com.mycompany.TaxService.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MyWriter implements ItemWriter<Transaction>{

	@Override
	public void write(List<? extends Transaction> items) throws Exception {
		for(Transaction txn : items) {
			String record = String.format("%s  |  %d  |  %d  |  %f ", txn.getTransactionId(),
					txn.getFromAccount(),txn.getToAccount(),txn.getAmount());
			System.out.println(record);
		}
	}

}
