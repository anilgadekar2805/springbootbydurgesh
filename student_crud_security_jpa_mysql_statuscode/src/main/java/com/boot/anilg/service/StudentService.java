package com.boot.anilg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.anilg.entity.Student;
import com.boot.anilg.exception.StudentNotFoundException;
import com.boot.anilg.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() throws Exception{
		List<Student> listStudent = (List<Student>)studentRepository.findAll();
		System.out.println("lsi is empty");
		if(listStudent.size()<=0)
			throw new Exception("Student list is empty");
		return listStudent;
	}
	
	public Student getStudentById(int id) throws StudentNotFoundException{
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("student not found with given id "+id));
	}
	
	public Student saveStudent(Student student) throws Exception {
		try {
		Student save = studentRepository.save(student);
		return save;
		}catch(Exception e) {
			throw new Exception("something goes wrong"+e); 
		}
		
	}
	
}
