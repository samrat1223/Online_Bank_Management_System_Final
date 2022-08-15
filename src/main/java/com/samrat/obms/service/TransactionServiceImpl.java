package com.samrat.obms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samrat.obms.model.Transaction;
import com.samrat.obms.repository.TransactionRepository;




@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		this.transactionRepository.save(transaction);
		
	}

	@Override
	public Transaction getTransactionByTransac_Id(long Transaction_Id) {
		
		Optional<Transaction> optional = transactionRepository.findById(Transaction_Id);
		Transaction transaction = null;
		
		if(optional.isPresent()) {
			transaction = optional.get();
			
		}
		else {
			throw new RuntimeException(" Transaction not found for this Transac_id :: "+ Transaction_Id);
		}
		
		return transaction;
	}



}

