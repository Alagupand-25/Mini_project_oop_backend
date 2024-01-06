package com.example.project.Material;

import com.example.project.File.FileModel;
import com.example.project.Subject.Subject;
import com.example.project.facility.model.Faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Material_table")
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean to_display;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "File_id",referencedColumnName = "id")
	private FileModel file;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CourseCode", referencedColumnName = "CourseCode")
	private Subject Subject;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "facultyid",referencedColumnName = "facultyid")
	private Faculty faculty;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Boolean getTo_display() {
		return to_display;
	}

	public FileModel getFile() {
		return file;
	}

	public Subject getSubject() {
		return Subject;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTo_display(Boolean to_display) {
		this.to_display = to_display;
	}

	public void setFile(FileModel file) {
		this.file = file;
	}

	public void setSubject(Subject subject) {
		Subject = subject;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	
}

