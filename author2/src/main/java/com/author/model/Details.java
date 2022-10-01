package com.author.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int bookId;
	public String title;
	public String category;
	public double price;
	
//	@ManyToOne
//	@JoinColumn(name="id")
	public int authorId;
	
	public String publisher;
	private boolean active;
	private String publishedDate;
	private String content;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(String title, String category, double price, int authorId, String publisher,
			boolean active, String publishedDate, String content) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.authorId = authorId;
		this.publisher = publisher;
		this.active = active;
		this.publishedDate = publishedDate;
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, authorId, bookId, category, content, price, publishedDate, publisher, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Details other = (Details) obj;
		return active == other.active && Objects.equals(authorId, other.authorId) && bookId == other.bookId
				&& Objects.equals(category, other.category) && Objects.equals(content, other.content)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publishedDate, other.publishedDate) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}
	
	
	

	
	
}
