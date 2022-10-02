package com.digitalbooks.authorservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.authorservice.model.AuthorDetails;

public interface AuthorRepository extends JpaRepository<AuthorDetails, Integer>{
	
	@Query("select u.password from AuthorDetails u where u.username=?1")
	public String filterByPassword(String username);

	@Query("select u from AuthorDetails u where u.username=?1")
	public Optional<AuthorDetails> findByName(String authorName);
}
