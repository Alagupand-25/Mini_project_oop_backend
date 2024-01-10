package com.example.project.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DataAccess.AuthRequestbody;

import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController{
	
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Registerbody registerbody){
		
		try {
			return authservice.registerUser(registerbody);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
    }
	
	@PostMapping
	public ResponseEntity<?> auth_user(@RequestBody AuthRequestbody request){
		try {
			 return authservice.authenticate_user(request);
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}  
	}

}