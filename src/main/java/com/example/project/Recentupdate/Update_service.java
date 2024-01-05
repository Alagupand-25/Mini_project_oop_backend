package com.example.project.Recentupdate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.File.FileModel;
import com.example.project.File.FileRepository;
import com.example.project.File.File_service;

@Service
public class Update_service {
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	File_service file_service;
	
	@Autowired
	Update_Repository update_Repository;
	
	public ResponseEntity<?> addRecent_update(Recentupdate_Request request,MultipartFile file) throws Exception{
		FileModel file_model = null;
		if(request != null) {
			Recent_update update = new Recent_update();
			update.setContent(request.getContent());
			update.setCreated_at(new Date(System.currentTimeMillis()));
			update.setExpire_at(new Date(System.currentTimeMillis()*63));
			update.setTitle(request.getTitle());
			update.setTo_facilityonly(request.isToFacilityOnly());
			update.setTo_display(true);
			System.out.println(update.getId());
			if(file != null) file_model = file_service.fileUpload(file,"update");
			update.setFile(file_model);
			
			update_Repository.save(update);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(update);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid request");
	}
	
	
}
