package com.samrat.obms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.Account;

/*we have added the @Repository annotation to indicate that the class provides the mechanism 
for storage, retrieval, update, delete and search operation on objects.*/

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	// Custom query to fetch account
	@Query(value = "SELECT * FROM account where Accnt_No=?1", nativeQuery = true)
	Optional<Account> findByAccountNo(long Accno);

}
