package com.example.project.Security;

import com.example.project.User.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;


@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthRequestbody {
	
	String email;
    String password;
    
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
}
