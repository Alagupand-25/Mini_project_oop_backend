package com.example.project.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> register(@RequestBody AuthRequestbody request){
		try {
			 return ResponseEntity.status(HttpStatus.OK).body(authservice.authenticate(request));
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}  

	 }
}