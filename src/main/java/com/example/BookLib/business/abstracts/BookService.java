package com.example.BookLib.business.abstracts;

import java.util.List;

import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.entities.concretes.Book;

public interface BookService {
	DataResult<List<Book>> getAll();
	Result add(Book book);
}
