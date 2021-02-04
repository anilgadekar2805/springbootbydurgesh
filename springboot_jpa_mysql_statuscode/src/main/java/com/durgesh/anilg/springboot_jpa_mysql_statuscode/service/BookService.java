package com.durgesh.anilg.springboot_jpa_mysql_statuscode.service;

import java.util.List;
import java.util.Optional;

import com.durgesh.anilg.springboot_jpa_mysql_statuscode.dao.BookRepository;
import com.durgesh.anilg.springboot_jpa_mysql_statuscode.enitities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getBook(int id) {
        Optional<Book> book = null;
           book = bookRepository.findById(id);
           return book;

    }
    
}
