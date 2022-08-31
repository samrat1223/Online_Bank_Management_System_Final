package com.samrat.obms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.Transaction;


/*we have added the @Repository annotation to indicate that the class provides the mechanism 
for storage, retrieval, update, delete and search operation on objects.*/

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	Optional<Transaction> getTransactionByTransac_Id(long Transaction_Id);
}
