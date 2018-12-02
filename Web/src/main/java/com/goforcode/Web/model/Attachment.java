package com.goforcode.Web.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "post" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Attachment.class)
@Entity
public class Attachment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AttachmentType type;

	@Lob
	private byte[] mediaContent;

	private String url;

	@ManyToOne
	private Post post;

	public Attachment() {
	
	}
	
	public Attachment(AttachmentType type, String url, Post post) {
		this.type = type;
		this.url = url;
		this.post = post;
	}

	public Attachment(AttachmentType type, byte[] mediaContent, Post post) {
		this.type = type;
		this.mediaContent = mediaContent;
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AttachmentType getType() {
		return type;
	}

	public void setType(AttachmentType type) {
		this.type = type;
	}

	public byte[] getMediaContent() {
		return mediaContent;
	}

	public void setMediaContent(byte[] mediaContent) {
		this.mediaContent = mediaContent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	

}
