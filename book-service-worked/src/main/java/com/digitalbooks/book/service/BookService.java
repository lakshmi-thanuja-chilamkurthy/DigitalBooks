package com.digitalbooks.book.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.book.entity.BookEntity;
import com.digitalbooks.book.entity.BuyBook;
import com.digitalbooks.book.exception.BookException;
import com.digitalbooks.book.repository.BookRepository;
import com.digitalbooks.book.repository.BuyRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BuyRepository buyRepo;

	public List<BookEntity> fetchAllBooks() {
		return bookRepo.findAll();

	}

	public BookEntity getBookById(int bookId) throws BookException {
		Optional<BookEntity> optional = bookRepo.findById(bookId);
		if (optional.isEmpty()) {
			throw new BookException("Book with id(" + bookId + ") not found");
		} else {
			return optional.get();
		}
	}

	public List<BookEntity> getBookByName(String name) {
		return bookRepo.findByName(name);
	}

	public List<BookEntity> getBooks(String category, String author, double price, String publisher){
		List<BookEntity> finalList = null;
		
		if (category != null && author != null && price != 0 && publisher != null) {
				
			finalList = bookRepo.findbycap(category,author,price,publisher);
		
		}else return null;
		
		return finalList;
	}

	public BookEntity create(BookEntity be) {
		
		return bookRepo.save(be);
	}

	
	public String saveData(BuyBook book)
    {
        int bId = book.getBookId(); 
        String str=buyRepo.findByBookName(bId);
        int a = ThreadLocalRandom.current().nextInt();
        int d=Math.abs(a);
        System.out.println("random number" + d);
        book.setGeneratedId(d);
        buyRepo.save(book);
        return "you have successfully purchased book and your book id is" + d;
        
    }
	

    
}
	


