package com.samrat.obms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
