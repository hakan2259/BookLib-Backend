package com.example.BookLib.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name="author_id")
	//private int authorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="category")
	private String category;
	
	@ManyToOne
    @JoinColumn(name="author_id")
	private Author author;
	
	
	
	
	
	
}
