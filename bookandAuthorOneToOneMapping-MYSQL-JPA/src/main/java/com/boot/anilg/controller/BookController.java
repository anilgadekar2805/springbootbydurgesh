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

import com.boot.anilg.entities.Book;
import com.boot.anilg.exception.BookNotFoundException;
import com.boot.anilg.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.CREATED);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id){
		Book findBook = bookService.findBookById(id);
		return ResponseEntity.ok(findBook);
	}
	
	@PostMapping("/books")
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		Book searchbook;
		try {
			searchbook = bookService.saveBook(book);
			return ResponseEntity.of(Optional.of(searchbook));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int id){
		Book resultBook;
		try {
			resultBook = bookService.updateBook(book, id);
			return ResponseEntity.ok(resultBook) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BookNotFoundException("something goes wrong in request");
		}
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable int id){
			bookService.deleteBook(id);
			return ResponseEntity.ok().build();
	}
}
