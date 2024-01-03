package com.example.project.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.User.Role;
import com.example.project.User.User;
import com.example.project.User.UserRepository;
import com.example.project.facility.model.Faculty;
import com.example.project.facility.model.FacultyRepository;

@Service
public class FacultyService {
		
	@Autowired
	FacultyRepository facultyRepo;
	@Autowired
	UserRepository userRepo; 
	
	public List<Faculty> getallFacility() throws Exception{
		return facultyRepo.findAll();
	}
	
	public ResponseEntity<?> getFacility(long facultyid) throws Exception{
		if(facultyRepo.existsByFacultyid(facultyid)){
			Faculty faculty = facultyRepo.getByFacultyid(facultyid);
			return ResponseEntity.status(HttpStatus.OK).body(faculty);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty does not already exits");
		}	
	}
	
	public ResponseEntity<?> addFacility(FacultyRequest request) throws Exception{
		if(userRepo.existsByEmail(request.getEmail())) {
			User user = userRepo.getByEmail(request.getEmail());
			if((!facultyRepo.existsByFacultyid(request.getFacultyid())) && ((user.getRole() == Role.Admin) || (user.getRole() == Role.Teacher ))) {
				Faculty faculty = new Faculty();
				faculty.setFacultyid(request.getFacultyid());
				faculty.setDesignation(request.getDesignation());
				faculty.setYear(request.getYear());
				faculty.setDept(request.getDept());
				faculty.setUser(user);
				facultyRepo.save(faculty);
				return ResponseEntity.status(HttpStatus.CREATED).body("Faculty registered successfully");
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Faculty already exits or not a Faculty");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not already exits");
	}
	
	public ResponseEntity<?> deleteFacility(long facultyid) throws Exception{
		if(facultyRepo.existsByFacultyid(facultyid)) {
			Faculty facility = facultyRepo.getByFacultyid(facultyid);
			User user = facility.getUser();
			facultyRepo.delete(facility);
			userRepo.delete(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Faculty deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty does not already exits");
	}

}
