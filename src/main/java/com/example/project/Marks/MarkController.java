package com.example.project.Marks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DataAccess.MarkRequest;
import com.example.project.DataAccess.StudentMarkRequest;

@RestController
@RequestMapping("api/mark/")
public class MarkController {
	
	@Autowired
	private MarkService markservice;
	
	@PostMapping
	public ResponseEntity<?> addMarks(@RequestBody MarkRequest request){
		try {
			return markservice.addMarks(request);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("student")
	
	public ResponseEntity<?> getByStudent(@RequestBody StudentMarkRequest request){
		try {
			return markservice.getByStudent(request);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
