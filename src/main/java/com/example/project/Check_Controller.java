package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Recentupdate.Update_service;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("api/check")
public class Check_Controller {
	
	@Autowired
	Update_service service;
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping
	public String getmethod(HttpServletRequest request) {
		service.getUpdate();
		return "hi you ";
	}
	
}
