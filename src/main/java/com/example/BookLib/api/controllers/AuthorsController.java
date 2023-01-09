package com.example.BookLib.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookLib.business.abstracts.AuthorService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.entities.concretes.Author;



@RestController
@RequestMapping("/api/authors")
public class AuthorsController {
	
	private AuthorService authorService;

	@Autowired
	public AuthorsController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@GetMapping("/getall")
	public DataResult<List<Author>> getAll(){
		return this.authorService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody Author author) {
		return this.authorService.add(author);
	}
}
