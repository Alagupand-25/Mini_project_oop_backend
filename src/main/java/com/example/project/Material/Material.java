package com.example.project.Material;

import com.example.project.Subject.Subject;
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
@Table(name = "Material_table")
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean to_display;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Subject_id",referencedColumnName = "id")
	private Subject Subject_id ;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "facultyid",referencedColumnName = "facultyid")
	private Faculty faculty;
	

}

