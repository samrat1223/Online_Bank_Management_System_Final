package com.samrat.obms.service;

import java.util.List;
import com.samrat.obms.model.Transaction;

//Interface providing all the methods to override in implementation class
public interface TransactionService {

	// Method to fetch all customer
	List<Transaction> getAllTransaction();

	// Method to save a particular customer
	Transaction saveTransaction(Transaction transaction);

	// Method to fetch a particular account by accnt_no
	Transaction getTransactionByTransac_Id(long Transaction_Id);

}
