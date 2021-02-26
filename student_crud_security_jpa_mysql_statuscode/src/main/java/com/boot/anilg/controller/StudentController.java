package com.boot.anilg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.anilg.entity.Student;
import com.boot.anilg.exception.StudentNotFoundException;
import com.boot.anilg.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student")
	public List<Student> allStudents() throws Exception{
		List<Student> allStudents = studentService.getAllStudents();
		return allStudents;
		
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable("id") int id) throws StudentNotFoundException {
		Student studentById = studentService.getStudentById(id);
		return studentById;
	}
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) throws Exception {
		System.out.println(student);	
		Student saveStudent = studentService.saveStudent(student);
			return saveStudent;
	}
	
	
}
