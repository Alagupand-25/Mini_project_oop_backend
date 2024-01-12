package com.example.project.DataTransfer;

import com.example.project.Student.Semester;

public class SubjectDto{
	
	private long id;
	private String name;
	private String coursecode;
	private String department;
	private Semester semester;
	private int Year;
	private FacultyDto faculty;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public FacultyDto getFaculty() {
		return faculty;
	}
	public void setFaculty(FacultyDto faculty) {
		this.faculty = faculty;
	}
	
}
