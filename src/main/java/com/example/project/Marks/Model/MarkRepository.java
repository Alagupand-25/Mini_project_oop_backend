package com.example.project.Marks.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Student.model.Semester;
import com.example.project.Student.model.Students;
import com.example.project.Subject.Subject;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findByStudentsAndSemesterAndYear(Students students, Semester semester, int year);
    boolean existsByStudentsAndTestAndSubjects(Students students, Test test, Subject subjects);
}
