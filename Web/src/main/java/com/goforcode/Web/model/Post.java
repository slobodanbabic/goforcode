package com.goforcode.Web.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "comments", "user", "labels", "attachments" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Post.class)
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Lob
	private Byte[] picture;

	@OneToMany(mappedBy = "post")
	private Set<Comment> comments = new HashSet<Comment>();

	@ManyToOne
	private User user;

	// using ManyToMany because one post can have multiple labels and
	// one label can have multiple posts
	@ManyToMany
	private Set<Label> labels = new HashSet<Label>();

	@OneToMany(mappedBy="post")
	private Set<Attachment> attachments = new HashSet<Attachment>();

	
	
	public Post() {
	}

	public Post(String content, Date date, User user) {
		this.content = content;
		this.date = date;
		this.user = user;
	}
	
	public Post(String content, Date date, Byte[] picture, User user) {
		this.content = content;
		this.date = date;
		this.picture = picture;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	

}
