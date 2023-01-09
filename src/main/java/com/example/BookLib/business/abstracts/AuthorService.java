package com.example.BookLib.business.abstracts;

import java.util.List;

import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.entities.concretes.Author;

public interface AuthorService {
	DataResult<List<Author>> getAll();
	Result add(Author author);
	
}
