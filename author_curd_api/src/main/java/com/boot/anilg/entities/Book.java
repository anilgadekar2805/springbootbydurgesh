package com.boot.anilg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;

	@Column(name = "book_name")
	private String name;

	
	/**
	 * # Bidirectional mapping using JACKSON 
	 * 	1. JsonManagedReference 	:	it manage this class as a child   
	 * 2. JsonBackReference			:  means don't back to given field table 
	 * */	
	
	
	/**
	 * # Uni-direction Mapping(Book to Author) # OneToOne(cascade = CascadeType.ALL)
	 * - its mapping between one table to another table here Author table Primary
	 * key work as foreign key in book_author table. - 'Cascade.Type.ALL' mean
	 * Before writing records in Book table must write inside Author Table first
	 * 
	 */

	/**
	 * # Bidirectional mapping using JACKSON 1. JsonManagedReference : it manage
	 * this class as a child 2. JsonBackReference : means don't back to given field
	 * table
	 */

	private double price;

	private String curency;
	
	
	@ManyToOne
	@JsonBackReference
	private Author author;

	public Book() {
	}

	public Book(int id, String name, double price, String curency, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.curency = curency;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurency() {
		return curency;
	}

	public void setCurency(String curency) {
		this.curency = curency;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}



	
}
