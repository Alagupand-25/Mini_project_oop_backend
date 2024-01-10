package com.example.project.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DataAccess.FacultyRequest;

@RestController
@RequestMapping("/api/faculty/")
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;
	
	@GetMapping
	public ResponseEntity<?> getallstudents(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(facultyService.getallFacility());
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<?> addFacility(@RequestBody FacultyRequest request)
	{
		try {
			return facultyService.addFacility(request);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping("{facilityid}")
	public ResponseEntity<?> getStudent(@PathVariable long facilityid){
		try {
			return facultyService.getFacility(facilityid);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{facultyid}")
	public ResponseEntity<?> deleteFacility(@PathVariable long facultyid){
		try {
			return facultyService.deleteFacility(facultyid);
		}
		catch (Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
