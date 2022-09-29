package com.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.author.model.AuthorDetails;

public interface AuthorRepository extends JpaRepository<AuthorDetails,Integer> {

	 @Query("select u.password from AuthorDetails u where u.username=?1")
      public String filterByPassword(String username);
	

}
