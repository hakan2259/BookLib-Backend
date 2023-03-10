package com.example.BookLib.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookLib.business.abstracts.AuthorService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.ErrorDataResult;
import com.example.BookLib.entities.concretes.Author;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/authors")
@CrossOrigin
public class AuthorsController {

	private AuthorService authorService;

	@Autowired
	public AuthorsController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Author>> getAll(){
		log.info("get all method called!");
		return this.authorService.getAll();
		
	}
	@PostMapping("/addAuthor")
	public ResponseEntity<?> add(@Valid @RequestBody Author author) {
		log.info("add author method called!");
		return ResponseEntity.ok(authorService.add(author));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(
			MethodArgumentNotValidException exceptions
			){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Verification Errors");
		return errors;
		
	}
	
	
	
	
}
