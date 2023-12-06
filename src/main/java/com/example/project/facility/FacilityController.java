package com.example.project.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facility/")
public class FacilityController {
	
	@Autowired
	FacilityService facilityService;
	
	@GetMapping
	public ResponseEntity<?> getallstudents(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(facilityService.getallFacility());
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> addStudents(@RequestBody FacilityRequest request)
	{
		try {
			return facilityService.addFacility(request);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@GetMapping("{facilityid}")
	public ResponseEntity<?> getStudent(@PathVariable long facilityid){
		try {
			return facilityService.getFacility(facilityid);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{facilityid}")
	public ResponseEntity<?> deleteFacility(@PathVariable long facilityid){
		try {
			return facilityService.deleteFacility(facilityid);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
