package com.boot.anilg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.anilg.entity.Student;

public interface StudentRepository extends  CrudRepository<Student, Integer>{

}
