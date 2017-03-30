package com.noteservice.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	
	@Id
	@Column(name="note_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String note;
	private Date createdDate;
	private Date updatedDate;
	
	public Note() {
		super();
	}
	public Note( String title, String note, Date createdDate, Date updatedDate) {
		super();
		this.title = title;
		this.note = note;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
