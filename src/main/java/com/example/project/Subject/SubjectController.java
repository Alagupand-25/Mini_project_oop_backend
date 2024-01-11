package com.example.project.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DataAccess.SubjectBasicDao;
import com.example.project.DataAccess.SubjectRequest;

@RestController
@RequestMapping("api/subject/")
public class SubjectController {
	
	@Autowired
	private SubjectService service;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<?> addSubject(@RequestBody SubjectRequest request)
	{
		try {
			return service.addSubject(request);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PreAuthorize("!hasAuthority('Students')")
	@GetMapping("faculty/{facultyId}")
	public ResponseEntity<?> getallsubjectFaculty(@PathVariable long facultyId){
		try {
			System.err.println(facultyId);
			return service.getallSubjectFaculty(facultyId);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PreAuthorize("hasAuthority('Students')")
	@GetMapping
	public ResponseEntity<?> getallsubject(@RequestBody SubjectBasicDao basicDao){
		try {
			return service.getallSubject(basicDao);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("update/{subject_id}")
	public ResponseEntity<?> updateSubject(@RequestBody SubjectRequest body,@PathVariable long subject_id){
		try {
			return service.updateSubject(subject_id, body);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
