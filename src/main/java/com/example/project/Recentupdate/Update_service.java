package com.example.project.Recentupdate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.File.FileModel;
import com.example.project.File.FileRepository;

@Service
public class Update_service {
	
	@Autowired
	FileRepository fileRepository;
	
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
			if(file != null) file_model = fileUpload(file);
			update.setFile(file_model);
			
			update_Repository.save(update);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(update);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid request");
	}
	
	public FileModel fileUpload(MultipartFile file)throws Exception {
		
		UUID uuid = UUID.randomUUID();
		String file_name = uuid+"_"+file.getOriginalFilename();
		String filePath = System.getProperty("user.dir") + "\\src\\resources\\update" + File.separator+file_name; 
        FileOutputStream fout = new FileOutputStream(filePath);
        fout.write(file.getBytes());         
        fout.close();
        
        FileModel file_model = new FileModel();
        file_model.setFileName(file_name);
        file_model.setFilePath(filePath);
        file_model.setFileType(file.getContentType());
        file_model.setSize(file.getSize());
        
        fileRepository.save(file_model);
        
		return file_model;
	}
}
