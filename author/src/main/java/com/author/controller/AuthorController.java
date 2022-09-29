package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.AuthorDetails;
import com.author.model.JwtResponse;
import com.author.repository.AuthorRepository;
import com.author.service.AuthorService;

@RestController
@RequestMapping("/api/v1/digitalbooks/author")
@CrossOrigin
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorRepository authorRepo;

	@PostMapping("/signup")
	public String saveCredentials(AuthorDetails author)
    {
		authorRepo.save(author);
        return "Your Account has been created, Please proceed with Login" ;
    }

//	public ResponseEntity<?> registerUser(@RequestBody AuthorDetails Ad) {
//
//		AuthorDetails author = new AuthorDetails();
//		author.setAuthorEmailId(Ad.getAuthorEmailId());
//		author.setUsername(Ad.getUsername());
//		author.setPassword(Ad.getPassword());
//		authorService.save(author);
//		return ResponseEntity.ok(new JwtResponse("User registered successfully"));
//	}

//	@PostMapping("/login")
//	public String login(@RequestBody AuthorDetails Ad){
//		AuthorDetails author= new AuthorDetails();
////        author.setAuthorEmailId(Ad.getAuthorEmailId());
//        author.setUsername(Ad.getUsername());
//        author.setPassword(Ad.getPassword());
//        
////		return ResponseEntity.ok(new JwtResponse("Login successfully"));
//        return "redirect:/login.html";		
//		
//	}

	@PostMapping("/login")
    public String authorLogin(@RequestBody AuthorDetails author)
    {
        String username=author.getUsername();
        System.out.println("username" +username);
        String password=author.getPassword();
        String s=authorService.validateUser(username,password);
        if(s.equalsIgnoreCase("success"))
        {
            return "Login Successfull";    
        }
        else if(s.equalsIgnoreCase("failure"))
        {
            return "Please enter correct password";
        }
        else
        {
            return "User is not available,Please register";
        }
        
    }

}
