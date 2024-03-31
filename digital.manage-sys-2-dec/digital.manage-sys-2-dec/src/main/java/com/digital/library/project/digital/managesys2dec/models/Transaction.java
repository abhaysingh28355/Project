package com.digital.library.project.digital.managesys2dec.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String transactionId;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value ="transaction")
	private Student student;
	
	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;
	
	@Enumerated(value = EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	private Integer fine;
	@ManyToOne
	@JoinColumn
	private Book book;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;

}
