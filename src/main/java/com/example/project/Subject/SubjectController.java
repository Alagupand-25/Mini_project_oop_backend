package com.example.project.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subject/")
public class SubjectController {
	
	@Autowired
	private SubjectService service;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<?> addStudents(@RequestBody SubjectRequest request)
	{
		try {
			return service.addSubject(request);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
