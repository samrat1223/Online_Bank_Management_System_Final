package com.samrat.obms.service;

import java.util.List;

import com.samrat.obms.model.Account;

// Interface providing all the methods to override in implementation class
public interface AccountService {

	// Method to fetch all account
	List<Account> getAllAccounts();

	// Method to save a particular account
	Account saveAccount(Account account);

	// Method to fetch a particular account by accnt_no
	Account getAccountById(long accnt_No);

	// Method to delete a account by accnt_no
	void deleteAccountById(long Accnt_No);
}
