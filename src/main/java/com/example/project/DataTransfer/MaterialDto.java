package com.example.project.DataTransfer;

public class MaterialDto {
	
	private String title;
	private String content;
	private FileDto file;
	private SubjectDto Subject;
	
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
	public FileDto getFile() {
		return file;
	}
	public void setFile(FileDto file) {
		this.file = file;
	}
	public SubjectDto getSubject() {
		return Subject;
	}
	public void setSubject(SubjectDto subject) {
		Subject = subject;
	}
	
}
