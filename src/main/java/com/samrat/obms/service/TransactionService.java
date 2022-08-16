package com.samrat.obms.service;

import java.util.List;

import com.samrat.obms.model.Transaction;
public interface TransactionService {
	List<Transaction> getAllTransaction();
	void saveTransaction(Transaction transaction);
	Transaction getTransactionByTransac_Id(long Transaction_Id );

}
