package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Security.JwtService;
import com.example.project.User.UserRepository;


@RestController
public class Controller {
	
	@Autowired
	JwtService jwtservice;
	@Autowired
	UserRepository userepo;
	@Autowired
	UserDetailsService userdetails;
	
	@GetMapping
	public UserDetails getdata() {
		return userdetails.loadUserByUsername("Alagupandi");
	}
	
	@GetMapping("/token")
	public String gettoken() {
		return jwtservice.generateToken("Alagupandi");
	}
	
	@GetMapping("/token_check")
	private Object calmier() {
		return jwtservice.extractUsername(gettoken());
	}
	
	@GetMapping("/token_expire")
	public Boolean gettokenexpire() {
		return jwtservice.isTokenExpired(gettoken());
	}

}
