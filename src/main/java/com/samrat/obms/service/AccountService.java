package com.samrat.obms.service;

import java.util.List;

import com.samrat.obms.model.Account;

// Interface providing all the methods to override in implementation class
public interface AccountService {

	List<Account> getAllAccounts();

	void saveAccount(Account account);

	Account getAccountById(long accnt_No);

	void deleteAccountById(long Accnt_No);
}
