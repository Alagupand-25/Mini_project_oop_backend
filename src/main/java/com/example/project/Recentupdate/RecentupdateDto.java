package com.example.project.Recentupdate;

import java.util.Date;

import com.example.project.File.FileDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class RecentupdateDto {
	
	private String title;
	private String content;
	private Date createdate;
	private Date expireat;
	private FileDto file;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getExpireat() {
		return expireat;
	}
	public void setExpireat(Date expireat) {
		this.expireat = expireat;
	}
	public FileDto getFile() {
		return file;
	}
	public void setFile(FileDto file) {
		this.file = file;
	}
	
}
