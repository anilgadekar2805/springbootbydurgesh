package com.boot.anilg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AuthorandBookApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AuthorandBookApplication.class, args);
	}
	
	/*
	 * Deploy war file creation 
	 * */
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(AuthorandBookApplication.class);
	 }
}
