package com.example.project.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class File_service {
	
	@Autowired
	FileRepository fileRepository;
	
	public FileModel fileUpload(MultipartFile file,String file_loc)throws Exception {
		
		UUID uuid = UUID.randomUUID();
		
		String file_name = uuid+"_"+file.getOriginalFilename();
		String filePath = System.getProperty("user.dir") + "\\src\\resources\\"+file_loc + File.separator + file_name; 
        
		FileOutputStream fout = new FileOutputStream(filePath);
        fout.write(file.getBytes());         
        fout.close();
        
        FileModel file_model = new FileModel();
        file_model.setFileName(file_name);
        file_model.setFilePath(filePath);
        file_model.setOriginal_name(file.getOriginalFilename());
        file_model.setFileType(file.getContentType());
        file_model.setSize(file.getSize());
        
		fileRepository.save(file_model);
        
		return file_model;
	}
	
	
	public ResponseEntity<?> File_download(String File_name, String file_loc) throws Exception {
		
	    String filePath = System.getProperty("user.dir") + "\\src\\resources\\" + file_loc + File.separator + File_name;
	    File file = new File(filePath);

	    if (file != null) {
	        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	        
	        String contentType = "application/octet-stream";
	        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
	                .body(resource);
	    }

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File not found");
	}
	
	public FileDto convertToDto(FileModel file) {
	    FileDto fileDto = new FileDto();
	    fileDto.setFileName(file.getFileName());
	    fileDto.setOriginal_name(file.getOriginal_name());
	    fileDto.setFileType(file.getFileType());
	    fileDto.setSize(file.getSize());  
	    return fileDto;
	}


}
