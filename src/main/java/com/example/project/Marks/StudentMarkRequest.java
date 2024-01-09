package com.example.project.Marks;

import com.example.project.Student.model.Semester;

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
