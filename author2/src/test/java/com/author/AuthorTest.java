//package com.author;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.author.model.AuthorDetails;
//import com.author.repository.AuthorRepository;
//import com.author.service.AuthorService;
//
//@SpringBootTest
//public class AuthorTest {
//	@Autowired
//	private AuthorService authorService;
//	
//	@MockBean
//	private AuthorRepository authorRepo;
//	
//	@Test
//	public void AuthorDetailsValidation() {
//		String str = new String("lak","lak@123");
//		Mockito.when(authorRepo.filterByPassword(str)).thenReturn(new String("demo@123"));
//		
//		String str1= authorService.validateUser(str, str)
//	}
//	
//
//}
