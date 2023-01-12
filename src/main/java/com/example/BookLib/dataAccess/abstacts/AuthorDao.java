package com.example.BookLib.dataAccess.abstacts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookLib.entities.concretes.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {
	
	Boolean existsByName(String authorName);
	
	
	
}
