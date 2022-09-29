package com.digitalbooks.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.book.entity.BuyBook;
import com.digitalbooks.book.service.BookService;
import com.digitalbooks.book.service.ReaderService;


@RestController
@RequestMapping("/api/v1/digitalbooks/readers")
public class ReaderController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private ReaderService  readerService;
	
	@GetMapping("/{emailId}/books")
	public List<BuyBook> getAllPurchasedBooks(@PathVariable String emailId){
		return readerService.getAllPurchasedBooks(emailId);
		
	}
	@GetMapping("/{emailId}/books/{bookId}")
	public String getPurchasedId(@PathVariable String emailId, @PathVariable int bookId){
		return readerService.getByEmailandId(emailId,bookId);
	}
	
	@PostMapping("/{emailId}/books")
	public String getPurchasedBookById(@PathVariable String emailId, @RequestParam int generatedId) {
		return readerService.getPurchasedBookByPid(emailId,generatedId);
		
	}
	

}
