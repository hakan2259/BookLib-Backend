package com.example.BookLib.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="authors")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Author name cannot be blank")
	@Size(min = 2, message = "Author name must have at least 2 characters")
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "country")
	private String country;
	
	@OneToMany(mappedBy="author")
	private List<Book> books;
	
	public Author() {}
	
	public Author(int id, String name, int age, String gender, String country) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.country = country;
	}
}
