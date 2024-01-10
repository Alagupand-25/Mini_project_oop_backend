package com.example.project.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.DataAccess.StudentsRequest;
import com.example.project.Student.model.Branch;
import com.example.project.Student.model.StudentRepo;
import com.example.project.Student.model.Students;
import com.example.project.User.Role;
import com.example.project.User.User;
import com.example.project.User.UserRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentsrepo;
	@Autowired
	UserRepository userRepo; 
	
	public List<Students> getallStudents() throws Exception{
		return studentsrepo.findAll();
	}
	
	public ResponseEntity<?> getstudent(long rollno) throws Exception{
		if(studentsrepo.existsByRollno(rollno)){
			Students student = studentsrepo.getByRollno(rollno);
			return ResponseEntity.status(HttpStatus.OK).body(student);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students does not already exits");
		}	
	}

	public ResponseEntity<?> addStudents(StudentsRequest request) throws Exception{
		if(userRepo.existsByEmail(request.getEmail())) {
			User user = userRepo.getByEmail(request.getEmail());
			if(!studentsrepo.existsByRollno(request.getrollno()) && user.getRole() == Role.Students ){
				Students student = new Students();
				student.setRollno(request.getrollno());
				student.setBranch(request.getBranch());
				student.setDept(request.getDept());
				student.setYear(request.getYear());
				student.setSemester(request.getSemester());
				student.setUser(user);
				studentsrepo.save(student);
				return ResponseEntity.status(HttpStatus.CREATED).body("Students registered successfully");
			}
			 return ResponseEntity.status(HttpStatus.CONFLICT).body("Students already exits or not a students");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not already exits");
	}
}
