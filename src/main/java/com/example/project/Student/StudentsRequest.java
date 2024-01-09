package com.example.project.Student;

import com.example.project.Student.model.Semester;

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
	private Semester semester;
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
	public Semester getSemester() {
		return semester;
	}
	public String getEmail() {
		return email;
	}
}
