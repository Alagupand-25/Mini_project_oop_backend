package com.example.project.facility.model;


import com.example.project.User.User;

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
@Table(name = "Facility_table")
public class Facility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private long facilityid;
	
	@Column(nullable = false)
	private String designation;
	
	@Column(nullable = false)
	private int year;
	
	@Column(nullable = false)
	private String dept;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_email",referencedColumnName = "email")
	private User user;

	public int getId() {
		return id;
	}

	public long getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(long facilityid) {
		this.facilityid = facilityid;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
