package com.example.project.Subject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.DataAccess.SubjectBasicDao;
import com.example.project.DataAccess.SubjectRequest;
import com.example.project.DataTransfer.SubjectDto;
import com.example.project.facility.FacultyRepository;
import com.example.project.facility.FacultyService;

@Service
public class SubjectService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	FacultyService facultyService;
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
	
	public ResponseEntity<?> updateSubject(long subject_id,SubjectRequest body) throws Exception{
		if(subjectRepository.existsById(subject_id)) {
			Subject subject = subjectRepository.getById(subject_id);
			if(subject != null) {
				subject.setCoursecode(body.getCoursecode());
				subject.setDepartment(body.getDepartment());
				subject.setFaculty(
						facultyRepository.getByFacultyid(
								body.getFacultyid()
							)
						);
				subject.setName(body.getName());
				subject.setSemester(body.getSemester());
				subject.setYear(body.getYear());
				subjectRepository.save(subject);
				return ResponseEntity.status(HttpStatus.OK).body(convertToDto(subject));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid input");
	}
	
	public ResponseEntity<?> getallSubject(SubjectBasicDao subjectDao) throws Exception{
		List<Subject> subjectlist = subjectRepository.findByDepartmentAndSemesterAndYear(
					subjectDao.getDepartment(),
					subjectDao.getSemester(),
					subjectDao.getYear()
				);
		List<SubjectDto> list = subjectlist.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	public SubjectDto convertToDto(Subject subject) {
		SubjectDto subjectdto = new SubjectDto();
		subjectdto.setId(subject.getId());
		subjectdto.setCoursecode(subject.getCoursecode());
		subjectdto.setDepartment(subject.getDepartment());
		subjectdto.setName(subject.getName());
		subjectdto.setSemester(subject.getSemester());
		subjectdto.setYear(subject.getYear());
		subjectdto.setFaculty(facultyService.convertToDto(subject.getFaculty()));
        return subjectdto;
    }

	public ResponseEntity<?> getallSubjectFaculty(long facultyId) throws Exception{
		if(facultyRepository.existsByFacultyid(facultyId)) {
			List<Subject> subjectlist = subjectRepository.findByFaculty(
						facultyRepository.getByFacultyid(facultyId)
					);
			List<SubjectDto> list = subjectlist.stream()
					.map(this::convertToDto)
					.collect(Collectors.toList());
			
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid input");
	}
}
