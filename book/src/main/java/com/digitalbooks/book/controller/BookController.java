package com.digitalbooks.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.book.entity.BookEntity;
import com.digitalbooks.book.entity.BuyBook;
import com.digitalbooks.book.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/books")
//@CrossOrigin
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
    public List<BookEntity> getAllBooks() {
        return bookService.fetchAllBooks();
    }
	
	@GetMapping("/{id}")
	public BookEntity getBookById(@PathVariable int id) throws Exception {
		return bookService.getBookById(id);
	}
	
	@GetMapping("/name")
	public List<BookEntity> getBookByName(@RequestParam("name") String name) {
		return bookService.getBookByName(name);
		
	}
	
	@GetMapping("/search")
	public List<BookEntity> getBooks(@RequestParam("category") String category, 
							   		 @RequestParam("author") String author, 
							         @RequestParam("price") Double price, 
							         @RequestParam("publisher") String publisher){
		return bookService.getBooks(category,author,price,publisher);
	}
	
	
	
	@PostMapping
	public BookEntity createBook(@RequestBody BookEntity be) {
		return bookService.create(be);
	}
	
	@PostMapping("/buy")
    public String buyBook(@RequestBody BuyBook buyBooks)
    {
        System.out.println("controller");
        return  bookService.saveData(buyBooks);
    }
    
	

	
	
}
