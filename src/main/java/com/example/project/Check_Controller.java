package com.example.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/check")
public class Check_Controller {
	
	@GetMapping
	public String getmethod() {
		return "hi fuck you";
		
	}
}
