package com.example.project.DataAccess;

import com.example.project.Student.Semester;

public class SubjectBasicDao {
	
	private String department;
	private int year;
	private Semester semester;
	
	public String getDepartment() {
		return department;
	}
	public Semester getSemester() {
		return semester;
	}
	public int getYear() {
		return year;
	}
}
