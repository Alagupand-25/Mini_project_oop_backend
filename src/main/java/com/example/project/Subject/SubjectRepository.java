package com.example.project.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Student.model.Semester;
import com.example.project.facility.model.Faculty;


public interface SubjectRepository extends JpaRepository<Subject,Integer>{
	Subject getByCoursecode(String coursecode);
	List<Subject> findByDepartmentAndSemesterAndYear(String department,Semester semester,int year);
	List<Subject> findByFaculty(Faculty faculty);
}
