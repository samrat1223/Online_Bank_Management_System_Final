package com.samrat.obms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.Transaction;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

