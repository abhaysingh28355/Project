package com.digital.library.project.digital.managesys2dec.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.digital.library.project.digital.managesys2dec.createRequest.BookcreateRequest.BookcreateRequestBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int count;
	
	@ManyToOne
	@JoinColumn
	private Author myAuthor;
	
	@Enumerated(value = EnumType.STRING)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn
	private Student student;
	
	@OneToMany(mappedBy ="myAuthor")
	private List<Transaction> transaction;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;

	

	public Object getMyAuthor() {
		// TODO Auto-generated method stub
		return null;
	}



	public static BookcreateRequestBuilder builder() {
		// TODO Auto-generated method stub
		return null;
	}



	public Object getstudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
