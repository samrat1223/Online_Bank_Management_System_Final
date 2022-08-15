package com.samrat.obms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samrat.obms.model.Customer;
import com.samrat.obms.repository.CustomerRepository;
import com.samrat.obms.service.CustomerService;
import com.samrat.obms.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineBankManagementSystemFinalApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */

	// Injecting the service to write the test cases for service
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	// Invoking customer repository to get mocked
	@MockBean
	private CustomerRepository customerRepository;
	
	//
	//@MockBean
	//private CustomerService customerService;

	// TestCase for getUser method
	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll())
				.thenReturn(Stream
						.of(new Customer(4, "sealdah", "Sany Das", "san123", "451444", "KJH655", "san@mail.com", 411445,
								41211, "Gujrat", "san123", "fatherName", "2000-02-01", 414541),
								new Customer(2, "Rahara", "Sayan Sharma", "say123", "4201444", "KRL655", "say@mail.com",
										4074445, 41210, "Pradeh", "say123", "motherName", "2001-04-01", 412401))
						.collect(Collectors.toList()));
		assertEquals(2, customerServiceImpl.getAllCustomers().size());
	}
	

	/*@Test
	public void getCustomerByIdTest()
	{
		int Cust_ID=2;
		when(customerRepository.findById(Cust_ID)).thenReturn(Stream
				.of(new Customer(4, "sealdah", "Sany Das", "san123", "451444", "KJH655", "san@mail.com", 411445,
						41211, "Gujrat", "san123", "fatherName", "2000-02-01", 414541)).collect(Collectors.toList()));
		assertEquals(1,customerServiceImpl.getCustomerById(Cust_ID).size());
	}*/
	
	@Test
	public void saveCustomerTest() {
		Customer customer  = new Customer(8, "Jaipur", "Sanai Das", "sana123", "451944", "KKJ655", "sana@mail.com", 4574445,
				410141, "Bihar", "sana123", "fatherName", "2004-02-01", 403541);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer,customerServiceImpl.saveCustomer(customer));
	}
	
	@Test
	public void deleteCustomerTest() {
		int Cust_Id=8;
		customerServiceImpl.deleteCustomerById(Cust_Id);
		verify(customerRepository,times(1)).deleteById(8);
	}
	
}
