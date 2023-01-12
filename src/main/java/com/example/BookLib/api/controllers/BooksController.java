package com.example.BookLib.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookLib.business.abstracts.BookService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.entities.concretes.Book;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BooksController {
	private BookService bookService;

	@Autowired
	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Book>> getAll(){
		return this.bookService.getAll();
	}
	
	@PostMapping("/addBook")
	public Result add(@RequestBody Book book) {
		return this.bookService.add(book);
		
	}
	
	@GetMapping("/search")
	public DataResult<List<Book>> getByNameContains(@RequestParam String searchText){
		return this.bookService.findBookBySearchCriteria(searchText);
		
	}
	
}
