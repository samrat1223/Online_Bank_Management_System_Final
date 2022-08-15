package com.samrat.obms.service;

import java.util.List;

import com.samrat.obms.model.Customer;

// Interface providing all the methods to override in implementation class
public interface CustomerService {

	List<Customer> getAllCustomers();

	Customer saveCustomer(Customer customer);

	Customer getCustomerById(int Cust_ID);

	void deleteCustomerById(int Cust_ID);
}
