package com.example.project.Material;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.DataAccess.Material_request;
import com.example.project.DataTransfer.MaterialDto;
import com.example.project.File.FileModel;
import com.example.project.File.File_service;
import com.example.project.Subject.Subject;
import com.example.project.Subject.SubjectRepository;
import com.example.project.Subject.SubjectService;

@Service
public class MaterialService {
	
	@Autowired
	File_service file_service;
	@Autowired
	SubjectService subjectService;
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
	
	public MaterialDto convertToDto(Material material) {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setContent(material.getContent());
        materialDto.setTitle(material.getTitle());
        materialDto.setFile(file_service.convertToDto(material.getFile()));
        materialDto.setSubject(subjectService.convertToDto(material.getSubject()));
        return materialDto;
    }
	
	public ResponseEntity<?> File_download(String file) throws Exception{
		return file_service.File_download(file,"Material");
	}
	
	public ResponseEntity<?> getallMaterial(String course_code) {
		Subject subject = subjectRepository.getByCoursecode(course_code);
		List<Material> material = material_Repository.findBySubject(subject);
		List<MaterialDto> list = material.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
