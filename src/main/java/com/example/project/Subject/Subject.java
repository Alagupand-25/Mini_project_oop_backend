 package com.example.project.Subject;

import com.example.project.Student.Semester;
import com.example.project.facility.Faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String coursecode;
	
	@Column(nullable = false)
	private String department;
	
	@Column(nullable = false)
	private Semester semester;
	
	@Column(nullable = false)
	private int year;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facultyid", referencedColumnName = "facultyid")
    private Faculty faculty;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this. year = year;
	}
	
	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public String getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}
