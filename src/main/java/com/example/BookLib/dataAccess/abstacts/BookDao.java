package com.example.BookLib.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookLib.entities.concretes.Book;

public interface BookDao extends JpaRepository<Book,Integer> {

}
