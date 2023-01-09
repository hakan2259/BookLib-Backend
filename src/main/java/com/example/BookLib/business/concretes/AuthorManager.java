package com.example.BookLib.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookLib.business.abstracts.AuthorService;
import com.example.BookLib.core.results.DataResult;
import com.example.BookLib.core.results.Result;
import com.example.BookLib.core.results.SuccessDataResult;
import com.example.BookLib.core.results.SuccessResult;
import com.example.BookLib.dataAccess.abstacts.AuthorDao;
import com.example.BookLib.entities.concretes.Author;

@Service
public class AuthorManager implements AuthorService {
	
	private AuthorDao authorDao;
	
	@Autowired
	public AuthorManager(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}
	@Override
	public DataResult<List<Author>> getAll() {
		
		return new SuccessDataResult<List<Author>>(
				this.authorDao.findAll()
				,"Data listed");
	}
	@Override
	public Result add(Author author) {
		this.authorDao.save(author);
		return new SuccessResult("Author added");
	}

}
