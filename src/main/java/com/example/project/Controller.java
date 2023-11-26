package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	@Autowired
	JwtService jwtservice;
	
	@GetMapping
	public String getdata() {
		return "hi";
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
