package com.example.oluniyin.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -58390506078017532L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String title;

	@Column(columnDefinition = "TEXT")
	private String body;

	@Temporal(TemporalType.TIMESTAMP)
	public Date postedOn;

	@Column(columnDefinition = "TEXT")
	private String teaser;

	private String slug;
	
	@ElementCollection
	private List<String> keywords;
	
	private Boolean active;

	@ManyToOne
	private Author author;

	@SuppressWarnings("unused")
	private Post() {

	}

	public Post(String title) {
		this.setTitle(title);
	}

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getPosteOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", posteOn=" + postedOn + ", teaser=" + teaser
				+ ", slug=" + slug + ", author=" + author + "]";
	}

}
