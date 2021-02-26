package com.boot.anilg.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.boot.anilg.exception.CustomErrorDetails;
import com.boot.anilg.exception.StudentNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> handleStudentNotFound(StudentNotFoundException e, WebRequest request) {
			CustomErrorDetails error = new CustomErrorDetails(e.getMessage(), new Date(), request.getContextPath());
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e, WebRequest request) {
			CustomErrorDetails error = new CustomErrorDetails(e.getMessage(), new Date(), request.getContextPath());
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
