package com.digitalbooks.authorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.authorservice.model.AuthorDetails;
import com.digitalbooks.authorservice.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
public String save(AuthorDetails author) {
		
//		int a = ThreadLocalRandom.current().nextInt();
//        int d = Math.abs(a);
//        System.out.println("random number for author "+ d);
//        author.setId(d);
        authorRepo.save(author);
        return "Registration success , Please Login" ;
		

	}

	public String validateUser(String username, String password) {
		String dbPassword = authorRepo.filterByPassword(username);
		if (dbPassword != null) {
			if (dbPassword.equals(password)) {
				return "success";
			} else {
				return "failure";
			}
		} else {
			return "false";
		}

	}

	public List<AuthorDetails> getAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}

//	public List<Details> createdBooks(AuthorDetails authorId, String title, String category, double price, String authorName,
//			String publisher, String publishedDate, String content) {
//		// TODO Auto-generated method stub
//		return detailsRepo.findByAuthorId(title,category,price,authorName,publisher,publishedDate,content);
//	}

//	public List<Details> getCreatedBooks(int authorId, String title, String category,
//			 double price,  String authorName, String publisher, String publishedDate,String content) {
//		// TODO Auto-generated method stub
//		return detailsRepo.findByAuthorId(title,category,price,authorName,publisher,publishedDate,content);
//	}

	


}
