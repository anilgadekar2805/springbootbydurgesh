package com.boot.anilg.entities;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book_author")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_name")
	private String name;
	
	/**
	 * # Uni-direction Mapping(Book to Author) 
	 *  # OneToOne(cascade = CascadeType.ALL)
	 * 		- its mapping between one table to another table here Author table Primary key work as
	 * 			foreign key in book_author table.
	 * 		- 'Cascade.Type.ALL' mean Before writing records in Book table must write inside Author Table first
	 * 
	 * */
	
	/**
	 * # Bidirectional mapping using JACKSON 
	 * 	1. JsonManagedReference 	:	it manage this class as a child   
	 * 2. JsonBackReference			:  means don't back to given field table 
	 * */
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	public Book() {
	}
	
	public Book(int id, String name, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}
