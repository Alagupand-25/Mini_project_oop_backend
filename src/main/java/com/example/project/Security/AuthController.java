package com.example.project.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.User.UserRepository;

import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthController {
	
	@Autowired
	JwtService jwtservice;
	UserRepository userepo;
	UserDetailsService userdetails;
	
	@GetMapping
	public String getdata() {
		return "hi";
	}
	
	@GetMapping("check_generateToken")
	public String gettoken() {
		return jwtservice.generateToken("admin@gmail.com");
	}
	
	@GetMapping("/token_check")
	private Object calmier() {
		return jwtservice.extractUsername(gettoken());
	}
	
	@GetMapping("/register")
	public Boolean gettokenexpire() {
		return jwtservice.isTokenExpired(gettoken());
	}

}