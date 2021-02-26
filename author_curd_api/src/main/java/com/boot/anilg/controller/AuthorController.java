package com.boot.anilg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.anilg.entities.Author;
import com.boot.anilg.exception.AuthorNotFoundException;
import com.boot.anilg.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	
	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAllAuthors() throws AuthorNotFoundException{
		return new ResponseEntity<List<Author>>(authorService.getAllBooks(), HttpStatus.CREATED);
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable("id") int id) throws AuthorNotFoundException{
		Author findAuthor = authorService.findAuthorById(id);
		return ResponseEntity.ok(findAuthor);
	}
	
	@PostMapping("/author")
	public ResponseEntity<?> saveAuhtor(@RequestBody Author author){
		Author searchAuthor= null;
		try {
			searchAuthor = authorService.saveAuthor(author);
			return ResponseEntity.of(Optional.of(searchAuthor));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/author/{id}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable int id) throws AuthorNotFoundException{
		Author resultAuthor;
		try {
			resultAuthor = authorService.updateAuthor(author, id);
			return ResponseEntity.ok(resultAuthor) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AuthorNotFoundException("something goes wrong in request with id "+id);
		}
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<Void> deleteAuthorById(@PathVariable int id) throws AuthorNotFoundException{
			authorService.deleteAuthor(id);
			return ResponseEntity.ok().build();
	}
}
