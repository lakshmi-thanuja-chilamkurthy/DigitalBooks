package com.digitalbooks.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.book.entity.BuyBook;

public interface BuyRepository extends JpaRepository<BuyBook, String>{
	
	@Query("select D from BuyBook D where D.emailId=:emailId")
	List<BuyBook> findByEmail(String emailId);
	
	@Query("select D.bookName from BuyBook D where D.emailId=emailId and D.bookId=bookId")
    public String filterByBookId(String emailId, int bookId);

	@Query("select D.bookName from BuyBook D where D.bookId=?1")
    public String findByBookName(int bookId);

	@Query("select D from BuyBook D where D.generatedId=?1")
	public String findByPid(String emailId, int generatedId);
	
	
}
