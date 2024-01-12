package com.example.project.Recentupdate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.DataAccess.Recentupdate_Request;
import com.example.project.User.Role;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/update/")
public class Recentupdate_controller {
	
	@Autowired
	Update_service update_service;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addRecent_update(@RequestParam("data") String jsonData,@RequestParam MultipartFile file){
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
	        Recentupdate_Request request = objectMapper.readValue(jsonData, Recentupdate_Request.class);
			return update_service.addRecent_update(request,file);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
    }
	
	@GetMapping("download/{path}")
	 public ResponseEntity<?> downloadFile(@PathVariable String file_name) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return update_service.File_download(file_name);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getUpdate() {
	    try {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.Students.name()))) {
	            return update_service.getUpdate();
	        } else {
	            return update_service.getUpdateFaculty();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}


}
