package com.digitalbooks.bookservice.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalbooks.bookservice.model.AuthorModel;


@FeignClient("AUTHOR-SERVICE")
public interface AuthorServiceClient {
	
	@GetMapping("/api/v1/digitalbooks/author/getAuthor/{aId}")
	Optional<AuthorModel> getAuthorByID(@PathVariable int aId);
	
	@GetMapping("/api/v1/digitalbooks/author/getAuthorName/{username}")
	Optional<AuthorModel> getAuthorByName(@PathVariable String username);

}
