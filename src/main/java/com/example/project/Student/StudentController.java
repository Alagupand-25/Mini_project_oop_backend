package com.example.project.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
	@PostMapping
	public ResponseEntity<?> addStudents(@RequestBody StudentsRequest request)
	{
		try {
			return studentsservice.addStudents(request);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	@GetMapping("{rollno}")
	public ResponseEntity<?> getStudent(@PathVariable long rollno){
		try {
			return studentsservice.getstudent(rollno);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
