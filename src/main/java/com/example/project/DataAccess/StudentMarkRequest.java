package com.example.project.DataAccess;

import com.example.project.Student.Semester;

public class StudentMarkRequest {
	long rollno;
	String semester;
	int year;
	
	public long getRollno() {
		return rollno;
	}
	public Semester getSemester() {
		return Semester.valueOf(semester);
	}
	public int getYear() {
		return year;
	}
	
}
