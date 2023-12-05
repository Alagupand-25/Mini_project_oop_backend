package com.example.project.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Security.Config.JwtService;

import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController{
	
	@Autowired
	JwtService jwtservice;
	@Autowired
	AuthService authservice;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registerbody registerbody){
		
		try {
			return authservice.registerUser(registerbody);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
    }
	
	@PostMapping("/facility")
	public ResponseEntity<?> auth_facility(@RequestBody AuthRequestbody request){
		try {
			 return authservice.authenticate_facility(request);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}  

	 }
	
	@PostMapping("/student")
	public ResponseEntity<?> auth_students(@RequestBody AuthRequestbody request){
		try {
			 return authservice.authenticate_students(request);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}  

	 }
}