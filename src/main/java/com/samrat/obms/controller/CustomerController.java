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

import com.samrat.obms.model.Customer;
import com.samrat.obms.service.CustomerService;

//Controller class to map the requests
@Controller
public class CustomerController {

	final Logger logger = Logger.getLogger(CustomerController.class.getName());

	// Invoking customerservice interface
	@Autowired
	private CustomerService customerService;

	// display list of customers
	@GetMapping("/view")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "index";
	}

	// GetMapping to add a new customer
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}

	// Postmapping to add a customer
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save customer to database
		customerService.saveCustomer(customer);
		return "redirect:/view";
	}

	// GetMapping to update a particular customer using cust_id
	@GetMapping("/showFormForUpdate/{Cust_ID}")
	public String showFormForUpdate(@PathVariable(value = "Cust_ID") int Cust_ID, Model model) {

		// get customer from the service
		Customer customer = customerService.getCustomerById(Cust_ID);

		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "update_customer";
	}

	// GetMapping to delete a particular customer
	@GetMapping("/deleteCustomer/{Cust_ID}")
	public String deleteCustomer(@PathVariable(value = "Cust_ID") int Cust_ID) {

		// call delete customer method
		this.customerService.deleteCustomerById(Cust_ID);
		return "redirect:/view";
	}

	// Fetching a user
	@GetMapping("/user")
	public String userdetails(Model model, HttpSession session) {
		String email = session.getAttribute("email").toString();
		Customer customer = customerService.findByemail(email);
		if (customer == null)
			throw new RuntimeException("No Customer Found!");
		model.addAttribute("customer", customer);
		return "userdetails";
	}

}
