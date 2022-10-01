package com.digitalbooks.authorservice.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String authorEmailId;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorEmailId() {
		return authorEmailId;
	}
	public void setAuthorEmailId(String authorEmailId) {
		this.authorEmailId = authorEmailId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthorDetails [id=" + id + ", authorEmailId=" + authorEmailId + ", username=" + username + ", password="
				+ password + "]";
	}
	public AuthorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthorDetails(String authorEmailId, String username, String password) {
		super();
		this.authorEmailId = authorEmailId;
		this.username = username;
		this.password = password;
	}
	public AuthorDetails(int id,String authorEmailId, String username, String password) {
		this(authorEmailId,username,password);
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorEmailId, id, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorDetails other = (AuthorDetails) obj;
		return Objects.equals(authorEmailId, other.authorEmailId) && id == other.id
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

}
