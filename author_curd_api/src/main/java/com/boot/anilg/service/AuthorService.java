package com.boot.anilg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.anilg.dao.AuthorRepository;
import com.boot.anilg.entities.Author;
import com.boot.anilg.exception.AuthorNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	// find all authors records
	public List<Author> getAllBooks() throws AuthorNotFoundException{
		List<Author> AuthorList = (List<Author>)authorRepository.findAll();
		if(AuthorList.size()<=0) {
			System.err.println("Author list is empty");	
			throw new AuthorNotFoundException("Author are not available right now");
		}
		return AuthorList;
	}
	
	// find author by ID
	public Author findAuthorById(int id) throws AuthorNotFoundException {
		return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException("book not found by given id : "+id));
		
	}
	
	// save Author
	public Author saveAuthor(Author author) throws Exception {
		try {
			System.out.println("saved author : "+author);
			Author savedAuthor = authorRepository.save(author);
			System.out.println("after saving book : \n"+savedAuthor);
			return savedAuthor;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("given record not saved");
		}		
	}

	// update author records
	public Author updateAuthor(Author author, int id) throws AuthorNotFoundException {
			Author findAuthor = this.findAuthorById(id);
			
			findAuthor.setFirstName(author.getFirstName());
				findAuthor.setLastName(author.getLastName());
				findAuthor.setEmail(author.getEmail());
				findAuthor.setContact(author.getContact());
				findAuthor.setBookList(author.getBookList());
				try {
					return this.saveAuthor(findAuthor);
				} catch (Exception e) {
					e.printStackTrace();
					throw new AuthorNotFoundException("Author not updated with given id :"+id);
				}
	}
	

	// delete author records
	public void deleteAuthor(int id) throws AuthorNotFoundException {
		Author findAuthorById = this.findAuthorById(id);
		authorRepository.deleteById(id);
	}
	
}
