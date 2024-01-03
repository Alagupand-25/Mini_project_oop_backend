package com.example.project.Marks;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Student.model.Students;
import com.example.project.Subject.Subject;

public interface MarkRepository extends JpaRepository<Mark,Long>{
	boolean existsByStudentsAndTestAndSubjects(Students students, Test test, Subject subjects);
}
