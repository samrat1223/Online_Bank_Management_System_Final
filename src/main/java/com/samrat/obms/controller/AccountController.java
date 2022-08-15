package com.samrat.obms.controller;

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

	@Autowired
	private AccountService accountService;

	// display list of account
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listAccounts", accountService.getAllAccounts());
		return "index";
	}

	@GetMapping("/showNewAccountForm")
	public String showNewAccountForm(Model model) {
		// create model attribute to bind form data
		Account account = new Account();
		model.addAttribute("account", account);
		return "new_account";
	}

	@PostMapping("/saveAccount")
	public String saveEmployee(@ModelAttribute("account") Account account) {
		// save employee to database
		accountService.saveAccount(account);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{Accnt_No}")
	public String showFormForUpdate(@PathVariable(value = "Accnt_No") long Accnt_No, Model model) {

		// get employee from the service
		Account account = accountService.getAccountById(Accnt_No);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("account", account);
		return "update_account";
	}

	@GetMapping("/deleteAccount/{Accnt_No}")
	public String deleteAccount(@PathVariable(value = "Accnt_No") long Accnt_No) {

		// call delete employee method
		this.accountService.deleteAccountById(Accnt_No);
		return "redirect:/";
	}
}
