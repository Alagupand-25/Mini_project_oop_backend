package com.example.project.Recentupdate;

import java.util.Date;

import com.example.project.File.FileModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "Recent_update")
public class Recent_update {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(nullable = false)
	private Date createdate;
	
	@Column(nullable = false)
	private Date expireat;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "File_id",referencedColumnName = "id")
	private FileModel file;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isfacilityonly;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean isdisplay;

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

	public boolean isIsfacilityonly() {
		return isfacilityonly;
	}

	public void setIsfacilityonly(boolean isfacilityonly) {
		this.isfacilityonly = isfacilityonly;
	}

	public Boolean getIsdisplay() {
		return isdisplay;
	}

	public void setIsdisplay(Boolean isdisplay) {
		this.isdisplay = isdisplay;
	}

	public int getId() {
		return id;
	}

	public FileModel getFile() {
		return file;
	}

	public void setFile(FileModel file) {
		this.file = file;
	}

	
	
}
