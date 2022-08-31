package com.samrat.obms.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samrat.obms.exceptions.TransactionNotFound;
import com.samrat.obms.model.Transaction;
import com.samrat.obms.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	final Logger logger=Logger.getLogger(TransactionServiceImpl.class.getName());
	
	// Invoking the repository
	@Autowired
	private TransactionRepository transactionRepository;

	// Method to get List of all Transactions
	@Override
	public List<Transaction> getAllTransaction() {

		return transactionRepository.findAll();
	}

	// Method to save a particular new transaction
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.save(transaction);

	}

	// Method to fetch a particular transaction by transaction Id
	@Override
	public Transaction getTransactionByTransac_Id(long Transaction_Id) {

		Optional<Transaction> optional = transactionRepository.findById(Transaction_Id);
		Transaction transaction = null;

		if (optional.isPresent()) {
			transaction = optional.get();

		} else {
			throw new TransactionNotFound(" Transaction not found for this Transac_id :: " + Transaction_Id);
		}

		return transaction;
	}
}
