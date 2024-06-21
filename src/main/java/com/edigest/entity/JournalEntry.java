package com.edigest.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "journals")
@Data
public class JournalEntry {
	@Id
	private ObjectId id;
	private String title;
	public LocalDateTime date;
	private String contents;
	
	
	
	
//	public ObjectId getId() {
//		return id;
//	}
//	public void setId(ObjectId id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public LocalDateTime getDate() {
//		return date;
//	}
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}
//	public String getContent() {
//		return contents;
//	}
//	public void setContent(String content) {
//		this.contents = content;
//	}
	
}
