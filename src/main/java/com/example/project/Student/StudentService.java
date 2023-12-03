package com.example.project.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentsrepo;
	
	public List<Students> getallStudents() throws Exception{
		return studentsrepo.findAll();
	}
}
