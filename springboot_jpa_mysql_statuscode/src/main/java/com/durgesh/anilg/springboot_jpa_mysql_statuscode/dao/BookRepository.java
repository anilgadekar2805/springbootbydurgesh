package com.durgesh.anilg.springboot_jpa_mysql_statuscode.dao;

import com.durgesh.anilg.springboot_jpa_mysql_statuscode.enitities.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

} 