package com.example.project.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.File.FileModel;
import com.example.project.File.File_service;
import com.example.project.Subject.Subject;
import com.example.project.Subject.SubjectRepository;

@Service
public class MaterialService {
	
	@Autowired
	File_service file_service;
	
	@Autowired
	Material_Repository material_Repository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public ResponseEntity<?> addMaterial(Material_request request,MultipartFile file) throws Exception{
		FileModel file_model = null;
		if(request != null) {
			Subject subject = subjectRepository.getByCoursecode(request.getCoursecode());
			Material material = new Material();
			material.setContent(request.getContent());
			material.setFaculty(subject.getFaculty());
			material.setSubject(subject);
			material.setTitle(request.getTitle());
			material.setTo_display(request.isTo_display());
			if(file != null) file_model = file_service.fileUpload(file,"Material");
			material.setFile(file_model);
			
			material_Repository.save(material);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(material);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid request");
	}
	
	public ResponseEntity<?> File_download(String file) throws Exception{
		return file_service.File_download(file,"Material");
	}
}
