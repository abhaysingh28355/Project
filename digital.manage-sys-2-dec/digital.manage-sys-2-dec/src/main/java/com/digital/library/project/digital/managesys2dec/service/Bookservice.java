package com.digital.library.project.digital.managesys2dec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.digital.library.project.digital.managesys2dec.Repo.BookRepos;
import com.digital.library.project.digital.managesys2dec.models.Author;
import com.digital.library.project.digital.managesys2dec.models.Book;

public class Bookservice {
	
	  @Autowired
	  BookRepos bookrepo;
	  
	  @Autowired
	  Authorservice authorservice;

	public void createbook(Book book) {
		// TODO Auto-generated method stub
		Author author=Authorservice.createorGetAuthor(book.getMyAuthor());
		//bookrepo.save(book);
		
	}

	public Book getBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookrepo.findById(bookId).orElse(null);
	}
	public List<Book> getBooks(){
			return bookrepo.findAll();
		
	}

}
