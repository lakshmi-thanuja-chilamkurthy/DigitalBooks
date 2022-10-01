package com.author.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.author.model.Details;

public interface DetailsRepo extends JpaRepository<Details,String> {
	
//	@Query("select u.authorId from details d where d.title=?1 "
//			+ "and d.category=?2 and d.price=?3 and d.authorName=?4 "
//			+ "and d.publisher=?5 and d.publishedDate=?6 and d.content=?7 ")
//	public List<Details> findByAuthorId(String title, String category, double price, String authorName,
//			String publisher, String publishedDate, String content);

}
