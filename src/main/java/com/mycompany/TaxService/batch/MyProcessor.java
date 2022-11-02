package com.mycompany.TaxService.batch;

import org.springframework.batch.item.ItemProcessor;

public class MyProcessor implements ItemProcessor<String, Transaction> {

	@Override
	public Transaction process(String item) throws Exception {
		String[] data = item.split(";");
		if (data.length != 4) {
			throw new Exception("Invalid Data");
		}
		Transaction txn = new Transaction();
		txn.setTransactionId(data[0]);
		txn.setFromAccount(Long.parseLong(data[1]));
		txn.setToAccount(Long.parseLong(data[2]));
		txn.setAmount(Double.parseDouble(data[3]));
		return txn;
	}

}
