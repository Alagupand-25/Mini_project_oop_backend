package com.example.project.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentsRequest {
	
	private long rollno;
	private String branch;
	private String dept;
	private int year;
	private int semester;
	private String email;
	
	public long getrollno() {
		return rollno;
	}
	public String getBranch() {
		return branch;
	}
	public String getDept() {
		return dept;
	}
	public int getYear() {
		return year;
	}
	public int getSemester() {
		return semester;
	}
	public String getEmail() {
		return email;
	}
}
