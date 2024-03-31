package com.digital.library.project.digital.managesys2dec.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentid;
	private String Name;
	private int age;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@OneToMany(mappedBy ="student")
	private List<Book>bookList;
	
	@OneToMany(mappedBy ="student")
	private List<Transaction> transaction;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;



	
}
