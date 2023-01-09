package com.example.BookLib.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookLib.business.abstracts.BookService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.core.results.SuccessDataResult;
import com.example.BookLib.core.results.SuccessResult;
import com.example.BookLib.dataAccess.abstacts.BookDao;
import com.example.BookLib.entities.concretes.Book;

@Service
public class BookManager implements BookService {

	private BookDao bookDao;
	
	@Autowired
	public BookManager(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
	@Override
	public DataResult<List<Book>> getAll() {
		
		return new SuccessDataResult<List<Book>>(
				this.bookDao.findAll(),
				"Book listed");
	}

	@Override
	public Result add(Book book) {
		this.bookDao.save(book);
		return new SuccessResult("Book added");
	}

}
