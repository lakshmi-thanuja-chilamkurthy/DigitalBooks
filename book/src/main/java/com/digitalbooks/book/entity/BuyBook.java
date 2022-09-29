package com.digitalbooks.book.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuyBook {
	
    private String name;
    private String emailId;
    @Id
    private int bookId;
    private int generatedId;
    private String bookName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId(int generatedId) {
		this.generatedId = generatedId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BuyBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyBook(String name, String emailId, int bookId, int generatedId, String bookName) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.bookId = bookId;
		this.generatedId = generatedId;
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "BuyBook [name=" + name + ", emailId=" + emailId + ", bookId=" + bookId + ", generatedId=" + generatedId
				+ ", bookName=" + bookName + "]";
	}
    
    
	
	

}
