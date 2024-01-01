package com.example.project.Marks;

import java.util.Date;
import java.util.List;

import com.example.project.Student.model.Students;
import com.example.project.Subject.Subject;
import com.example.project.facility.model.Faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Mark_table")
public class Mark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CourseCode", referencedColumnName = "CourseCode")
	private List<Subject> subjects;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "rollno",referencedColumnName = "rollno")
	private List<Students> students;
	
	@Column(nullable = false,columnDefinition = "boolean default true")
	private boolean attended;
	
	@Column(nullable = false,columnDefinition = "int default 0")
	private int marks_obtained;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "Faculty",referencedColumnName = "facultyid")
	private List<Faculty> faculty; 
	
	@Column(nullable = false)
	private Test test;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private int year;
	
	@Column(nullable = false)
	private Semester semester;

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}

	public int getMarks_obtained() {
		return marks_obtained;
	}

	public void setMarks_obtained(int marks_obtained) {
		this.marks_obtained = marks_obtained;
	}

	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public long getId() {
		return id;
	}
	
}
