package com.boot.anilg.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="author_id")
	private int id;
	
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "invalid email address")
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	
	/**
	 *  @OneToOne(mappedBy = "book") : mean Inside author table don't create extra column like book_bookId,
	 *  	 it is possible by 'mappedBy'='author', here 'author' is foreign key field name in Book class.
	 *  	Using above it recursive call from book to Author and Author to Book it's problem  
	 *  
	 *  @JsonBackReference - means don't back to Book table it work as a child, 
	 *  
	 * */
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference 
	private Contact contact;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	@JsonManagedReference
	private List<Book> bookList;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}


	public Author(int id,
			String email,
			String firstName, String lastName, Contact contact , List<Book> bookList) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.bookList = bookList;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}


	@Override
	public String toString() {
		return "Author [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contact=" + contact + ", bookList=" + bookList + "]";
	}

	
	
}
