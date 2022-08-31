package com.samrat.obms.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.Customer;

/*we have added the @Repository annotation to indicate that the class provides the mechanism 
for storage, retrieval, update, delete and search operation on objects.*/

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// Custom query to fetch customer details
	@Query(value = "SELECT * FROM customer where cust_email=?1", nativeQuery = true)
	Optional<Customer> findByemail(String email);

}
