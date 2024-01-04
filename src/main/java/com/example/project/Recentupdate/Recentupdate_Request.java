package com.example.project.Recentupdate;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Recentupdate_Request {
	
    private String title;
    private String content;
    private boolean toFacilityOnly;
	private Date expire_at;
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public boolean isToFacilityOnly() {
		return toFacilityOnly;
	}
	
	public Date getExpire_at() {
		return expire_at;
	}
    
}
