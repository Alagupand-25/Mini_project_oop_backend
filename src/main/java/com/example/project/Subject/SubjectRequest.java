package com.example.project.Subject;

import com.example.project.Marks.Semester;

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
