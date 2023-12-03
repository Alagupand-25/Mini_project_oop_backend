package com.example.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Student.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
	@Autowired
	StudentService studentsservice;
	
	@GetMapping
	public ResponseEntity<?> getallstudents(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentsservice.getallStudents());
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
