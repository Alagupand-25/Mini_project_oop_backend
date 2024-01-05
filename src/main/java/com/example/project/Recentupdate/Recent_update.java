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
import jakarta.persistence.ManyToOne;
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
@Table(name = "Recent_update_table")
public class Recent_update {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(nullable = false)
	private Date created_at;
	
	@Column(nullable = false)
	private Date expire_at;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "File_id",referencedColumnName = "id")
	private FileModel file;
	
	@Column(columnDefinition = "boolean default false")
	private boolean to_facilityonly;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean to_display;

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getExpire_at() {
		return expire_at;
	}

	public void setExpire_at(Date expire_at) {
		this.expire_at = expire_at;
	}

	public boolean isTo_facilityonly() {
		return to_facilityonly;
	}

	public void setTo_facilityonly(boolean to_facilityonly) {
		this.to_facilityonly = to_facilityonly;
	}

	public Boolean getTo_display() {
		return to_display;
	}

	public void setTo_display(Boolean to_display) {
		this.to_display = to_display;
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
