package com.samrat.obms.controller;

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

	@Autowired
	private CustomerService customerService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "index";
	}

	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new_customer";
	}

	@PostMapping("/saveCustomer")
	public String saveEmployee(@ModelAttribute("customer") Customer customer) {
		// save employee to database
		customerService.saveCustomer(customer);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{Cust_ID}")
	public String showFormForUpdate(@PathVariable(value = "Cust_ID") int Cust_ID, Model model) {

		// get employee from the service
		Customer customer = customerService.getCustomerById(Cust_ID);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "update_customer";
	}

	@GetMapping("/deleteCustomer/{Cust_ID}")
	public String deleteCustomer(@PathVariable(value = "Cust_ID") int Cust_ID) {

		// call delete employee method
		this.customerService.deleteCustomerById(Cust_ID);
		return "redirect:/";
	}
}
