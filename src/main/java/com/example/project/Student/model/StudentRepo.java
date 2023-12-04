package com.example.project.Student.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Integer>{
	List<Students> findAll();
	boolean existsByRollno(long rollno);
	Students getByRollno(long rollno);
};
