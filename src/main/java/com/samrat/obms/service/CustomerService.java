package com.samrat.obms.service;

import java.util.List;
import java.util.Optional;

import com.samrat.obms.model.Customer;

// Interface providing all the methods to override in implementation class
public interface CustomerService {

	// Method to fetch all customer
	List<Customer> getAllCustomers();

	// Method to save a particular customer
	Customer saveCustomer(Customer customer);

	// Method to fetch a particular account by accnt_no
	Customer getCustomerById(int Cust_ID);

	// Method to delete a account by accnt_no
	void deleteCustomerById(int Cust_ID);
	
	Customer findByemail(String email);
}
