package com.boot.anilg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="author_id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String language;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Category bookCategory;

	/**
	 *  @OneToOne(mappedBy = "author") : mean Inside author table don't create extra column like book_bookId,
	 *  	 it is possible by 'mappedBy'='author', here 'author' is foreign key field name in Book class.
	 *  	Using above it recursive call from book to Author and Author to Book it's problem  
	 *  
	 *  @JsonBackReference - means don't back to Book table it work as a child, 
	 *  
	 * */
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;

	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Author(int id, String firstName, String lastName, String language, Category bookCategory) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.bookCategory = bookCategory;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Category getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}

	@Override
	public String toString() {
		return "Author [bookCategory=" + bookCategory + ", firstName=" + firstName + ", id=" + id + ", language="
				+ language + ", lastName=" + lastName + "]";
	}
	
	

}
