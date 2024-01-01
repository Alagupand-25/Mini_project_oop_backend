package com.example.project.Subject;

import com.example.project.facility.model.Faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "Subject_table")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String Title;
	
	@Column(nullable = false,unique = true)
	private String CourseCode;
	
	@Column(nullable = false)
	private String department;
	
	@Column(nullable = false)
	private int Year;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facultyid",referencedColumnName = "facultyid")
	private Faculty faculty ;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getCourseCode() {
		return CourseCode;
	}

	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}

	public Faculty getFacility() {
		return faculty;
	}

	public void setFacility(Faculty faculty) {
		this.faculty = faculty;
	}
	
}
