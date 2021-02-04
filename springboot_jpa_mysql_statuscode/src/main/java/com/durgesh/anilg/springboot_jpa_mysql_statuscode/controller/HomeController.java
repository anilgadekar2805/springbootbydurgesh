package com.durgesh.anilg.springboot_jpa_mysql_statuscode.controller;

import java.util.List;
import java.util.Optional;

import com.durgesh.anilg.springboot_jpa_mysql_statuscode.enitities.Book;
import com.durgesh.anilg.springboot_jpa_mysql_statuscode.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  
    @Autowired
    BookService bookSerive;

    // get all books
    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> allBooks(){
           List<Book> books = bookSerive.getBooks();
           if(books.size()<=0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return ResponseEntity.of(Optional.of(books));
    }
    
    
}
