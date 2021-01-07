package com.boot.anilg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.anilg.dao.BookRepository;
import com.boot.anilg.entities.Book;
import com.boot.anilg.exception.BookNotFoundException;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	// find all books
	public List<Book> getAllBooks(){
		List<Book> bookList = (List<Book>)bookRepository.findAll();
		if(bookList.size()<=0) {
			System.err.println("empty book list");	
			throw new BookNotFoundException("Books are not available right now");
		}
		return bookList;
	}
	
	// find book by using ID
	public Book findBookById(int id) {
		return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("book not found by given id : "+id));
	}
	
	// save records
	public Book saveBook(Book book) throws Exception {
		try {
			Book savedBook = bookRepository.save(book);
			return savedBook;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("given record not saved");
		}		
	}

	// update records
	public Book updateBook(Book book, int id) {
			Book findBook = findBookById(id);
				findBook.setId(book.getId());
				findBook.setName(book.getName());
				findBook.setAuthor(book.getAuthor());
				findBook.setPrice(book.getPrice());
				try {
					return saveBook(findBook);
				} catch (Exception e) {
					e.printStackTrace();
					throw new BookNotFoundException("record not updated with given id :"+id);
				}
	}
	
	// delete records
	public void deleteBook(int id) {
		this.findBookById(id);
		bookRepository.deleteById(id);
	}
	
}
