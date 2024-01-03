package com.example.project.Marks;

import java.util.Date;


public class MarkRequest {

	private String coursecode;
	private long rollno;
	private boolean attended;
	private int marks_obtained;
	private String test;
	private Date date;
	private Result result;
	
	public String getCoursecode() {
		return coursecode;
	}
	public long getRollno() {
		return rollno;
	}
	public boolean isAttended() {
		return attended;
	}
	public int getMarks_obtained() {
		return marks_obtained;
	}

	public String getTest() {
		return test;
	}
	public Date getDate() {
		return date;
	}
	public Result getResult() {
		return result;
	}
	
	
}
