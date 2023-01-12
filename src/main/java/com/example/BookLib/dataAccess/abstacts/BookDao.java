package com.example.BookLib.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.BookLib.entities.concretes.Book;

public interface BookDao extends JpaRepository<Book,Integer> {
	
	
	@Query("From Book b INNER JOIN b.author a WHERE b.name LIKE %:searchText% OR b.category LIKE %:searchText% OR b.isbn LIKE %:searchText% OR a.name LIKE %:searchText%")
	List<Book> findBookBySearchCriteria(@Param("searchText") String searchText);
	
	Boolean existsByName(String bookName);
	
}
