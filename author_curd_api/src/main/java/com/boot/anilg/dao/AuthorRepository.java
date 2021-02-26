package com.boot.anilg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.anilg.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
