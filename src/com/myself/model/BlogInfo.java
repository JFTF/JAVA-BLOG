package com.myself.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog_info")
public class BlogInfo {
    
	@Id
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscuss() {
		return discuss;
	}
	public void setDiscuss(String discuss) {
		this.discuss = discuss;
	}
	@ManyToOne
	@JoinColumn(name="blog_Id")
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	private int   id;
	private String   discuss;
	private Blog  blog;
   
 
}
