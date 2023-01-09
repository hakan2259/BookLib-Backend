package com.example.BookLib.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="author_id")
	private int authorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="category")
	private String category;
	
	public Book() {}

	public Book(int id, int authorId, String name, String isbn, String category) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.name = name;
		this.isbn = isbn;
		this.category = category;
	}
	
	
	
	
}
