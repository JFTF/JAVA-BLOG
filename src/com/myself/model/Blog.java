package com.myself.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.myself.model.user.UserInfo;

@Entity
@Table(name="blog_content")
public class Blog {
	@Id
	@GeneratedValue
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(length=100000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
   
   
	@Column(name="blog_content_time")
	public Date getBlogContentTime() {
		return blogContentTime;
	}
	public void setBlogContentTime(Date blogContentTime) {
		this.blogContentTime = blogContentTime;
	}
	@ManyToOne
	@JoinColumn(name="nick_name")
    public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	private int  id;
	private String title;
    private String content;
	private String category;
	private UserInfo user;
	private Date blogContentTime;

 }
