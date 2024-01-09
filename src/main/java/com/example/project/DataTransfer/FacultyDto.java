package com.example.project.DataTransfer;

public class FacultyDto {

	private long facultyid;
	private String designation;
	private int year;
	private String dept;
	private UserDto user;
	
	public long getFacultyid() {
		return facultyid;
	}
	public void setFacultyid(long facultyid) {
		this.facultyid = facultyid;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	

}
