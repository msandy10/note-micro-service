package com.noteservice.pojo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoteDTO extends Audit{
	private Long id;
	private String title;
	private String note;
	private String createdBy;
	private String updatedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public NoteDTO(String title, String note) {
		this.title = title;
		this.note = note;
	}
	public NoteDTO(Long id,String title, String note) {
		this.id = id;
		this.title = title;
		this.note = note;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
