package com.samrat.obms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.samrat.obms.model.Account;
import com.samrat.obms.model.Customer;
import com.samrat.obms.model.Transaction;
import com.samrat.obms.model.User;
import com.samrat.obms.repository.AccountRepository;
import com.samrat.obms.repository.CustomerRepository;
import com.samrat.obms.repository.TransactionRepository;
import com.samrat.obms.repository.UserRepository;
import com.samrat.obms.service.AccountServiceImpl;
import com.samrat.obms.service.CustomerService;
import com.samrat.obms.service.CustomerServiceImpl;
import com.samrat.obms.service.TransactionServiceImpl;
import com.samrat.obms.service.UserServiceImpl;

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
	
	// Injecting the service to write the test cases for service
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	// Invoking account repository to get mocked
	@MockBean
	private AccountRepository accountRepository;
	
	// Invoking transaction repository to get mocked
	@MockBean
	private TransactionRepository transactionRepository;
	
	// Injecting the service to write the test cases for service
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	// TestCase for getUser method
	@Test
	 void getAllCustomersTest() {
		when(customerRepository.findAll())
				.thenReturn(Stream
						.of(new Customer(4, "sealdah", "Sany Das", "san123", "451444", "KJH655", "san@mail.com", 411445,
								41211, "Gujrat", "san123", "fatherName", "2000-02-01", 414541),
								new Customer(2, "Rahara", "Sayan Sharma", "say123", "4201444", "KRL655", "say@mail.com",
										4074445, 41210, "Pradeh", "say123", "motherName", "2001-04-01", 412401))
						.collect(Collectors.toList()));
		assertEquals(2, customerServiceImpl.getAllCustomers().size());
	}
	
	//Test Case for save a customer
	@Test
	 void saveCustomerTest() {
		Customer customer  = new Customer(8, "Jaipur", "Sanai Das", "sana123", "451944", "KKJ655", "sana@mail.com", 4574445,
				410141, "Bihar", "sana123", "fatherName", "2004-02-01", 403541);
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer,customerServiceImpl.saveCustomer(customer));
	}
	
	//Test Case for delete a user by Cust_Id 
	@Test
	 void deleteCustomerTest() {
		int Cust_Id=8;
		customerServiceImpl.deleteCustomerById(Cust_Id);
		verify(customerRepository,times(1)).deleteById(8);
	}
	
	
	//Test Case for fetching user details by email
	@Test
	void findCustomerByEmailTest()
	{
		String email="san@gmail.com";
		final Customer customer = new Customer(4, "sealdah", "Sany Das", "san123", "451444", "KJH655", "san@mail.com", 411445,
				41211, "Gujrat", "san123", "fatherName", "2000-02-01", 414541);
		
		Mockito.<Optional<Customer>>when(customerRepository.findByemail(email)).thenReturn(Optional.of(customer));
		
		final Optional<Customer> expected = Optional.ofNullable(customerServiceImpl.findByemail(email));
		assertThat(expected).isNotNull();
	}
	
	//Test Cases for account service//
	
	//Test Case for getallAccount method
	@Test
	 void getAllAccountsTest() {
		when(accountRepository.findAll()).thenReturn(Stream.of(new Account(120144,"savings",145874,"454kl","2014-10-14",
				"khardah","14511",41244,"mothername"),new Account(123104,"current",140354,"454lPo","2003-11-15",
				"rahara","17502",41017,"fathername")).collect(Collectors.toList()));
		assertEquals(2,accountServiceImpl.getAllAccounts().size());
	}
	
	//Test Case for save account method
	@Test
	 void saveAccountTest() {
		Account account = new Account(12475,"savings",140814,"4547pl","2001-05-14",
				"Kalighat","13501",48444,"fathername");
		when(accountRepository.save(account)).thenReturn(account);
		assertEquals(account,accountServiceImpl.saveAccount(account));
	}
	
	
	//Test Case for get Account Details by AccountId
	@Test
	void getAccountByIdTest() {
		 Long Accnt_No=1L;
		final Account account = new Account(1,"savings",140814,"4547pl","2001-05-14",
				"Kalighat","13501",48444,"fathername");
		Mockito.<Optional<Account>>when(accountRepository.findByAccountNo(Accnt_No)).thenReturn(Optional.of(account));
		final Optional<Account> expected = Optional.ofNullable(accountServiceImpl.getAccountById(Accnt_No));
		assertThat(expected).isNotNull();
	}
	
	
	//Test Case for delete a user by Accnt_No
	@Test
	 void deleteAccountTest() {
		long Accnt_No=12475;
		accountServiceImpl.deleteAccountById(Accnt_No);
		verify(accountRepository,times(1)).deleteById((long) 12475);
	}
	
	
	//Test Cases for transaction service//
	
	//Test case for getAllTransaction Method
	@Test
	 void getAllTransactionTest() {
		when(transactionRepository.findAll()).thenReturn(Stream.of(new Transaction(14781,4788,"2021-10-10","Ram",
				"Shyam","Credit",411444),new Transaction(14714,4008,"2022-10-10","Ramu",
						"Jane","Debit",406144)).collect(Collectors.toList()));
		assertEquals(2,transactionServiceImpl.getAllTransaction().size());
	}
	
	//TestCase for get a transaction by Id
		@Test
		void getTransactionById() 
		{
			final Long Transaction_Id = 1L;
			final Transaction transaction = new Transaction(1,5701,"2022-11-05","Rani",
					"Raghu","Credit",410178);
			Mockito.<Optional<Transaction>>when(transactionRepository.getTransactionByTransac_Id(Transaction_Id)).thenReturn(Optional.of(transaction));
			final Optional<Transaction> expected = Optional.ofNullable(transactionServiceImpl.getTransactionByTransac_Id(Transaction_Id));
			assertThat(expected).isNotNull();
		}
	
	//TestCase for saveTransaction
	@Test
	 void saveTransactionTest()
	{
		Transaction transaction = new Transaction(18641,5701,"2022-11-05","Rani",
				"Raghu","Credit",410178);
		when(transactionRepository.save(transaction)).thenReturn(transaction);
		assertEquals(transaction,transactionServiceImpl.saveTransaction(transaction));
	}
	
}

