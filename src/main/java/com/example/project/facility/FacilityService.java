package com.example.project.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.User.Role;
import com.example.project.User.User;
import com.example.project.User.UserRepository;
import com.example.project.facility.model.Facility;
import com.example.project.facility.model.FacilityRepository;

@Service
public class FacilityService {
		
	@Autowired
	FacilityRepository facilityRepo;
	@Autowired
	UserRepository userRepo; 
	
	public List<Facility> getallFacility() throws Exception{
		return facilityRepo.findAll();
	}
	
	public ResponseEntity<?> getFacility(long facilityid) throws Exception{
		if(facilityRepo.existsByFacilityid(facilityid)){
			Facility facility = facilityRepo.getByFacilityid(facilityid);
			return ResponseEntity.status(HttpStatus.OK).body(facility);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students does not already exits");
		}	
	}
	
	public ResponseEntity<?> addFacility(FacilityRequest request) throws Exception{
		if(userRepo.existsByEmail(request.getEmail())) {
			User user = userRepo.getByEmail(request.getEmail());
			if((facilityRepo.existsByFacilityid(request.getFacilityid())) && ((user.getRole() == Role.Admin) || (user.getRole() == Role.Teacher ))) {
				Facility facility = new Facility();
				facility.setFacilityid(request.getFacilityid());
				facility.setDesignation(request.getDesignation());
				facility.setYear(request.getYear());
				facility.setDept(request.getDept());
				facility.setUser(user);
				facilityRepo.save(facility);
				return ResponseEntity.status(HttpStatus.CREATED).body("Facility registered successfully");
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Facility already exits or not a Facility");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not already exits");
	}
	
	public ResponseEntity<?> deleteFacility(long facilityid) throws Exception{
		if(facilityRepo.existsByFacilityid(facilityid)) {
			Facility facility =facilityRepo.getByFacilityid(facilityid);
			User user = facility.getUser();
			facilityRepo.delete(facility);
			userRepo.delete(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Facility deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Facility does not already exits");
	}

}
