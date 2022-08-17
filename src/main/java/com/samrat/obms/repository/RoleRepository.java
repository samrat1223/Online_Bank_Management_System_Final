package com.samrat.obms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samrat.obms.model.Role;

/*we have added the @Repository annotation to indicate that the class provides the mechanism 
for storage, retrieval, update, delete and search operation on objects.*/
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByRole(String role);
}
