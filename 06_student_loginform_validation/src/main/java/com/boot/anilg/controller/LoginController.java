package com.boot.anilg.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.anilg.model.LoginData;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("invoke login form");
		LoginData data = new LoginData();
	//	data.setUserName("anilgadekar");
	//	data.setEmail("xyz@gmail.com");
		model.addAttribute("loginData", data);
		return "login-form";
	}
	
	// hander to passed data and validate
	@PostMapping("/login-process")
	public String loginValidate(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult r) {
		System.out.println(loginData);
		if(r.hasErrors()) {
			System.out.println(r);
			return "login-form";
		}
		return "success";
	}
	
	
}
