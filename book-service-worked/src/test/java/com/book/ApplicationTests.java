//package com.book;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.digitalbooks.book.repository.BookRepository;
//import com.digitalbooks.book.service.BookService;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Autowired
//	private BookService bookService;
//	
//	@MockBean
//	private BookRepository bookRepo;
//	
//	
//	@Test
//	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
//	      Mockito.when(bookService.getBookByName()).thenReturn("Mock Product Name");
//	      String testName = bookRepo.findByName();
//	      Assert.assertEquals("Mock Product Name", testName);
//	   }
//
//}
