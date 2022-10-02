package com.digitalbooks.bookservice.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.bookservice.client.AuthorServiceClient;
import com.digitalbooks.bookservice.entity.BookEntity;
import com.digitalbooks.bookservice.entity.BuyBook;
import com.digitalbooks.bookservice.exception.BookException;
import com.digitalbooks.bookservice.model.AuthorModel;
import com.digitalbooks.bookservice.repository.BookRepository;
import com.digitalbooks.bookservice.repository.BuyRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	BuyRepository buyRepo;

	@Autowired
	AuthorServiceClient authorServiceClient;

	public BookEntity createBookByAuthor(int authorId, BookEntity book) throws BookException {
		Optional<AuthorModel> authorEntity = authorServiceClient.getAuthorByID(authorId);
//		Optional<AuthorModel> authorEntity2 = authorServiceClient.getAuthorByName(authorName);
		BookEntity bookdetails = new BookEntity();
		if (!authorEntity.isEmpty()) {
			if (book.getCategory() != null) {
				bookdetails.setActive(book.isActive());
				bookdetails.setAuthorId(authorId);
//				bookdetails.setAuthorName(authorName);
				bookdetails.setAuthorName(book.getAuthorName());
				bookdetails.setCategory(book.getCategory());
				bookdetails.setContents(book.getContents());
				bookdetails.setPrice(book.getPrice());
				bookdetails.setPublishedDate(book.getPublishedDate());
				bookdetails.setPublisher(book.getPublisher());
				bookdetails.setTitle(book.getTitle());
				bookRepo.save(bookdetails);
			} else {
				throw new BookException("give all details");
			}
		} else {
			throw new BookException("Invalid Book ID or Author ID...");
		}
		return bookdetails;
	}

	public BookEntity updateBookByAuthor(int authorId, int bookId, BookEntity book) throws BookException {

		Optional<BookEntity> bookDetails = bookRepo.getBookDetailsByBookIdAndAuthorId(authorId, bookId);

		if (!bookDetails.isEmpty()) {
			if (book.getCategory() != null) {
				bookDetails.get().setCategory(book.getCategory());
			}

			if (Objects.nonNull(book.getContents())) {
				bookDetails.get().setContents(book.getContents());
			}

			if (Objects.nonNull(book.getPublishedDate())) {
				bookDetails.get().setPublishedDate(book.getPublishedDate());
			}

			if (Objects.nonNull(book.getPublisher())) {
				bookDetails.get().setPublisher(book.getPublisher());
			}

			if (Objects.nonNull(book.getPrice())) {
				bookDetails.get().setPrice(book.getPrice());
			}
			if (Objects.nonNull(book.isActive())) {
				bookDetails.get().setActive(book.isActive());
			}
			return bookRepo.save(bookDetails.get());

		} else {
			throw new BookException("Invalid Book ID or Author ID... Please check and retry");
		}
	}

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

	public List<BookEntity> getBooks(String category, String authorName, double price, String publisher) {
		List<BookEntity> booksList = new ArrayList();
//		Optional<AuthorModel> authorEntity = null;

		if (category != null && authorName != null && price != 0 && publisher != null) {
//			authorEntity = authorServiceClient.getAuthorByName(authorName);

			booksList = bookRepo.findbycap(category, authorName, price, publisher);

		} else
			return null;

		return booksList;
	}

	public String saveData(BuyBook book) {
		int bId = book.getBookId();
		String str = buyRepo.findByBookName(bId);
		int a = ThreadLocalRandom.current().nextInt();
		int d = Math.abs(a);
		System.out.println("random number " + d);
		book.setGeneratedId(d);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		book.setDate(formatter.format(date));
		buyRepo.save(book);
		return "you have successfully purchased book and your book id is " + d;

	}

	public String blockBook(int authorId, int bookId) throws BookException {
		Optional<BookEntity> optionalBook = bookRepo.getBookDetailsByBookIdAndAuthorId(authorId, bookId);

		if (optionalBook.isEmpty()) {
			throw new BookException("Book doesn't exit");
		} else {
			optionalBook.get().setActive(false);
			bookRepo.save(optionalBook.get());
		}

		return "Book Blocked Successfullly";
	}
}
