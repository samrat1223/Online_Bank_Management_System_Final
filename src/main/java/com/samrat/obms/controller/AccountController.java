package com.samrat.obms.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.samrat.obms.model.Account;
import com.samrat.obms.service.AccountService;

//Controller class to map the requests
@Controller
public class AccountController {

	final Logger logger = Logger.getLogger(AccountController.class.getName());
	private static final String ACCOUNT = "account";
	// Invoking accountservice interface
	@Autowired
	private AccountService accountService;

	// display list of account
	@GetMapping("/account")
	public String viewHomePage(Model model) {
		model.addAttribute("listAccounts", accountService.getAllAccounts());
		return "account_index";
	}

	// Get mapping to add a new account
	@GetMapping("/showNewAccountForm")
	public String showNewAccountForm(Model model) {
		// create model attribute to bind form data
		Account account = new Account();
		model.addAttribute(ACCOUNT, account);
		return "new_account";
	}

	// PostMapping to save a account
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute(ACCOUNT) Account account) {
		// save account to database
		accountService.saveAccount(account);
		return "redirect:/account";

	}

	// Updating a particular account
	@GetMapping("/showFormForAccountUpdate/{Accnt_No}")
	public String showFormForUpdate(@PathVariable(value = "Accnt_No") long Accnt_No, Model model) {

		// get account from the service
		Account account = accountService.getAccountById(Accnt_No);

		// set account as a model attribute to pre-populate the form
		model.addAttribute(ACCOUNT, account);
		return "update_account";
	}

	// Delete a particular account
	@GetMapping("/deleteAccount/{Accnt_No}")
	public String deleteAccount(@PathVariable(value = "Accnt_No") long Accnt_No) {

		// call delete account method
		this.accountService.deleteAccountById(Accnt_No);
		return "redirect:/account";
	}

	// Fetching the list of all accounts
	@GetMapping("/accountList")
	public String accountdetails(Model model, HttpSession session) {
		model.addAttribute(ACCOUNT, accountService.getAllAccounts());
		return "accountdetails";
	}
}
