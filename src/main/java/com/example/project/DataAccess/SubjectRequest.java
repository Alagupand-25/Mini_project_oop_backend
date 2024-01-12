package com.example.project.DataAccess;

import com.example.project.Student.Semester;

public class SubjectRequest {

	private String name;
	private String coursecode;
	private String department;
	private int year;
	private Semester semester;
	private long facultyid ;
	
	public String getName() {
		return name;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public String getDepartment() {
		return department;
	}
	public int getYear() {
		return year;
	}
	public Semester getSemester() {
		return semester;
	}
	public long getFacultyid() {
		return facultyid;
	}
	
}
