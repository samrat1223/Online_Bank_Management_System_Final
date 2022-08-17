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

import com.samrat.obms.model.Transaction;
import com.samrat.obms.service.TransactionService;

@Controller
public class TransactionController {

	final Logger logger = Logger.getLogger(TransactionController.class.getName());

	// Invoking the transaction interface
	@Autowired
	private TransactionService transactionService;

	// display list of Transaction
	@GetMapping("/transaction")
	public String viewHomePage(Model model) {
		model.addAttribute("listTransactions", transactionService.getAllTransaction());
		return "transac_index";
	}

	//GetMapping to add a new transaction
	@GetMapping("/showNewTransactionForm")
	public String showNewTransactionForm(Model model) {

		// create model attribute to bind Data
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
		return "new_transaction";

	}

	//PostMapping to save a transaction
	@PostMapping("/saveTransaction")
	public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {

		// save new transaction to database
		transactionService.saveTransaction(transaction);
		return "redirect:/transaction";

	}

	//GetMapping to fetch a transaction by transaction id
	@GetMapping("/getTransactionByTransac_Id/{Transaction_Id}")
	public String getTransactionByTransac_Id(@PathVariable Long Transaction_Id) {

		transactionService.getTransactionByTransac_Id(Transaction_Id);
		return "TransacDetails";

	}

	//Fetching a  transaction
	@GetMapping("/transactionList")
	public String transactiondetails(Model model, HttpSession session) {
		model.addAttribute("transaction", transactionService.getAllTransaction());
		return "transactiondetails";
	}
}
