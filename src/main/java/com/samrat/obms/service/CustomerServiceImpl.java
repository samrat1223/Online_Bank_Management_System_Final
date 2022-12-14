package com.samrat.obms.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samrat.obms.exceptions.CustomerNotFound;
import com.samrat.obms.model.Customer;
import com.samrat.obms.repository.CustomerRepository;

//Implementing the methods of repository 

@Service
public class CustomerServiceImpl implements CustomerService {

	final Logger logger=Logger.getLogger(CustomerServiceImpl.class.getName());
	
	// Invoking customer repository
	@Autowired
	private CustomerRepository customerRepository;

	// Method to fetch all the customers
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	// Method to save a customer
	@Override
	public Customer saveCustomer(Customer customer) {
		return this.customerRepository.save(customer);

	}

	// Method to fetch a particular customer
	@Override
	public Customer getCustomerById(int Cust_ID) {
		Optional<Customer> optional = customerRepository.findById(Cust_ID);
		Customer customer = null;
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new CustomerNotFound(" Customer not found for id :: " + Cust_ID);
		}
		return customer;
	}

	// Delete a particular customer
	@Override
	public void deleteCustomerById(int Cust_ID) {
		this.customerRepository.deleteById(Cust_ID);

	}
	
	// Fetching a user bu email
	 @Override 
	 public Customer findByemail(String email) { 
		 Optional<Customer>customer = this.customerRepository.findByemail(email);
	  
	 return customer.orElse(null); 
	 }
	 
}
