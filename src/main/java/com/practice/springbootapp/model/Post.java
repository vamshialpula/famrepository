package com.practice.springbootapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="POST")
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String description;

	@ManyToOne(fetch=FetchType.LAZY)
	private Family fmember;

	public Post() {
	}

	public Post(Long id, String description, Family fmember) {
		super();
		this.id = id;
		this.description = description;
		this.fmember = fmember;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Family getFmember() {
		return fmember;
	}

	public void setFmember(Family fmember) {
		this.fmember = fmember;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", fmember=" + fmember + "]";
	}

}
