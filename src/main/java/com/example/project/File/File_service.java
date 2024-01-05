package com.example.project.File;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class File_service {
	
	@Autowired
	FileRepository fileRepository;
	
	public FileModel fileUpload(MultipartFile file,String file_loc)throws Exception {
		
		UUID uuid = UUID.randomUUID();
		
		String file_name = uuid+"_"+file.getOriginalFilename();
		String filePath = System.getProperty("user.dir") + "\\src\\resources\\"+file_loc + File.separator+file_name; 
        
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
