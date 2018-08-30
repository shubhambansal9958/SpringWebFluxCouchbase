package com.spring.webflux.model;

import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Course {
	
	@Id
	@Field
	private int id;
	
	@Field
	private String name;
	
	@Field
	private int hours;
	
	@Field
	private String tutorName;
	
	@Field
	private List<String> chapters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public List<String> getChapters() {
		return chapters;
	}

	public void setChapters(List<String> chapters) {
		this.chapters = chapters;
	}
	
	@Override
	public String toString() {
		return id+" : "+name+" : "+hours+" : "+tutorName+" : "+chapters;
	}

}
