package com.example.project.Marks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.Student.model.StudentRepo;
import com.example.project.Student.model.Students;
import com.example.project.Subject.Subject;
import com.example.project.Subject.SubjectRepository;

@Service
public class MarkService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarkRepository markRepository;

    public ResponseEntity<?> addMarks(MarkRequest request) {
        Students students = studentRepo.getByRollno(request.getRollno());
        
        if (students != null) {
        	Subject subject = subjectRepository.getByCoursecode(request.getCoursecode());
            if (!markRepository.existsByStudentsAndTestAndSubjects(
            			students, 
            			Test.valueOf(request.getTest()), 
            			subject
            		)
            	) 
            {
                Mark mark = new Mark();
                mark.setStudents(students);
                mark.setSubjects(subject);
                mark.setAttended(request.isAttended());
                mark.setMarks_obtained(request.getMarks_obtained());
                mark.setFaculty(subject.getFaculty());
                mark.setTest(request.getTest());
                mark.setYear(students.getYear());
                mark.setSemester(subject.getSemester());
                mark.setResult(request.getResult());
                mark.setDate(request.getDate());
                
                markRepository.save(mark);
                
                return ResponseEntity.status(HttpStatus.CREATED).body(mark);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Marks for the given student, test, subjects, and semester already exist");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student with the provided roll number not found");
        }
    }
    
    public ResponseEntity<?> getByStudent(long rollno){
    	if(studentRepo.existsByRollno(rollno)) {
    		
    	}
    	return null;
    }
}
