package com.example.project.Recentupdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.DataAccess.Recentupdate_Request;
import com.example.project.DataTransfer.RecentupdateDto;
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
			update.setCreatedate(new Date(System.currentTimeMillis()));
			update.setExpireat(new Date(System.currentTimeMillis()*63));
			update.setTitle(request.getTitle());
			update.setIsdisplay(true);
			update.setIsfacilityonly(request.isToFacilityOnly());;
			System.out.println(update.getId());
			if(file != null) file_model = file_service.fileUpload(file,"update");
			update.setFile(file_model);
			
			update_Repository.save(update);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(update);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid request");
	}

	public ResponseEntity<?> File_download(String file_name) throws Exception {
		return file_service.File_download(file_name,"update");
	}
	
	public ResponseEntity<?> getUpdate() throws Exception {
		ArrayList<Recent_update> recentUpdates = update_Repository.findByIsdisplayTrueAndIsfacilityonlyFalseAndExpireatAfter(new Date(System.currentTimeMillis()));
		List<RecentupdateDto> list = recentUpdates.stream()
	                .map(this::convertToDto)
	                .collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	public ResponseEntity<?> getUpdateFaculty() throws Exception {
		ArrayList<Recent_update> recentUpdates = update_Repository.findByIsdisplayTrueAndExpireatAfter(new Date(System.currentTimeMillis()));
        List<RecentupdateDto> list = recentUpdates.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	public RecentupdateDto convertToDto(Recent_update recentUpdate) {
        RecentupdateDto recentupdateDto = new RecentupdateDto();
        recentupdateDto.setTitle(recentUpdate.getTitle());
        recentupdateDto.setContent(recentUpdate.getContent());
        recentupdateDto.setCreatedate(recentUpdate.getCreatedate());
        recentupdateDto.setExpireat(recentUpdate.getExpireat());
        recentupdateDto.setFile(file_service.convertToDto(recentUpdate.getFile()));
        return recentupdateDto;
    }
}
