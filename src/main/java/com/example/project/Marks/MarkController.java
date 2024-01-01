package com.example.project.Marks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController {
	
	@Autowired
	private MarkService markservice;
	
	@PreAuthorize("hasAuthority('Teacher') or hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<?> addMarks(){
		return markservice.addMarks();
	}
}
