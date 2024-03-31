package com.digital.library.project.digital.managesys2dec.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.project.digital.managesys2dec.createRequest.BookcreateRequest;
import com.digital.library.project.digital.managesys2dec.models.Author;
import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.service.Bookservice;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RestController
@Entity
@AllArgsConstructor
@NoArgsConstructor
 @Getter
@Setter
@Builder
public class BookController {
	
	@Autowired
	Bookservice bookservice;
	@PostMapping("/book")
	public void createbook(@RequestBody BookcreateRequest bookcreateRequest) {
		bookservice.createbook(bookcreateRequest.to());
	}
	@GetMapping("/book/all")
	public List<Book> getallBooks() {
		return bookservice.getBooks();
	}
	@GetMapping("/book/{bookId}")
	public void getBookById(@PathVariable("bookId") int bookId) {
		bookservice.getBookById(bookId);
	}

}
