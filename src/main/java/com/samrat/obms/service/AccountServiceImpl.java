package com.samrat.obms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samrat.obms.model.Account;
import com.samrat.obms.repository.AccountRepository;

//Implementing the methods of repository 

@Service
public class AccountServiceImpl implements AccountService {

	// Invoking account repository
	@Autowired
	private AccountRepository accountRepository;

	// Method to fetch all the accounts
	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	// Method to save a account
	@Override
	public Account saveAccount(Account account) {
		return this.accountRepository.save(account);

	}

	// Method to fetch a particular account
	@Override
	public Account getAccountById(long Accnt_No) {
		Optional<Account> optional = accountRepository.findById(Accnt_No);
		Account account = null;
		if (optional.isPresent()) {
			account = optional.get();
		} else {
			throw new RuntimeException(" Account not found for id :: " + Accnt_No);
		}
		return account;
	}

	// Delete a particular account
	@Override
	public void deleteAccountById(long Accnt_No) {
		this.accountRepository.deleteById(Accnt_No);

	}
}