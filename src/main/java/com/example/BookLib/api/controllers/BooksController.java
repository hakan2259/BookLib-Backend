package com.example.BookLib.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookLib.business.abstracts.BookService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.entities.concretes.Book;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	private BookService bookService;

	@Autowired
	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Book>> getAll(){
		return bookService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Book book) {
		return bookService.add(book);
		
	}
	
}
