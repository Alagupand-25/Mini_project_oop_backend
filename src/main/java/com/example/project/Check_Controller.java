package com.example.project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/check")
public class Check_Controller {
	
	
	@GetMapping
	public String getmethod(HttpServletRequest request) {
		return "hi fuck you "+request.getUserPrincipal();	
	}
	
}