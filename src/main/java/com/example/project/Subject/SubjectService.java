package com.example.project.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.facility.model.FacultyRepository;

@Service
public class SubjectService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public ResponseEntity<?> addSubject(SubjectRequest request) throws Exception{
		if(facultyRepository.existsByFacultyid(request.getFacultyid())) {
			Subject subject = new Subject();
			subject.setName(request.getName());
			subject.setCoursecode(request.getCoursecode());
			subject.setDepartment(request.getDepartment());
			subject.setYear(request.getYear());
			subject.setSemester(request.getSemester());
			subject.setFaculty(
					facultyRepository.getByFacultyid(
							request.getFacultyid()
						)
					);
			subjectRepository.save(subject);
			return ResponseEntity.status(HttpStatus.CREATED).body(subject);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid input");
	}
}
