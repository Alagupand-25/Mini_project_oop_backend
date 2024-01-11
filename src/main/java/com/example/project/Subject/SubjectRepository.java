package com.example.project.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Student.Semester;
import com.example.project.facility.Faculty;


public interface SubjectRepository extends JpaRepository<Subject,Long>{
	boolean existsById(long id);
	Subject getById(long id);
	Subject getByCoursecode(String coursecode);
	List<Subject> findByDepartmentAndSemesterAndYear(String department,Semester semester,int year);
	List<Subject> findByFaculty(Faculty faculty);
}
