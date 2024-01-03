package com.example.project.facility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class FacultyRequest {
	
	private int id;
	private long facultyid;
	private String designation;
	private int year;
	private String dept;
	private String email;
	
	public int getId() {
		return id;
	}
	public long getFacultyid() {
		return facultyid;
	}
	public String getDesignation() {
		return designation;
	}
	public int getYear() {
		return year;
	}
	public String getDept() {
		return dept;
	}
	
	public String getEmail() {
		return email;
	}
	
}
