package com.digitalbooks.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbooks.book.entity.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity,String>{

//	List<Reader> findByEmail(String emailId);
	
	

}
