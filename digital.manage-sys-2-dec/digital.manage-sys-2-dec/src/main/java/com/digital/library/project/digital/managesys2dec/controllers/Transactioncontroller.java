package com.digital.library.project.digital.managesys2dec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.project.digital.managesys2dec.service.TransactionService;

@RestController
public class Transactioncontroller {
	
	
	@Autowired
	TransactionService transactionservice;
	
	@PostMapping("/Transaction/issue")
	public String issueBook(@RequestParam("bookId")int bookId, @RequestParam("studentId")int studentId) {
		return transactionservice.issueBook(bookId, studentId);
	}
	
	@PostMapping("/Transaction/return")
	public void returnBook(@RequestParam("bookId")int bookId, @RequestParam("studentId")int studentId) {
		return transactionservice.returnbook(bookId, studentId);
	}

}
