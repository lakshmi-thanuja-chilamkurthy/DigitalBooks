package com.digitalbooks.authorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.authorservice.model.AuthorDetails;

public interface AuthorRepository extends JpaRepository<AuthorDetails, String>{
	
	@Query("select u.password from AuthorDetails u where u.username=?1")
	public String filterByPassword(String username);

}
