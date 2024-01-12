package com.example.project.facility;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FacultyRepository extends JpaRepository<Faculty,Integer> {
	List<Faculty> findAll();
	boolean existsByFacultyid(long facultyid);
	Faculty getByFacultyid(long facultyid);
}
