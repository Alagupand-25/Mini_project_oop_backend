package com.example.project.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/Material/")
public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	@PostMapping
	public ResponseEntity<?> addMaterial(@RequestParam("data") String jsonData,@RequestParam MultipartFile file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
	        Material_request request = objectMapper.readValue(jsonData, Material_request.class);
			return materialService.addMaterial(request,file);
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	 @GetMapping("/download/{path}")
	 public ResponseEntity<?> downloadFile(@PathVariable String path) {
		try {
			return materialService.File_download(path);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	 
	 @GetMapping("{course_code}")
	 public ResponseEntity<?> getallMaterial(@PathVariable String course_code) {
		try {
			return materialService.getallMaterial(course_code);
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
