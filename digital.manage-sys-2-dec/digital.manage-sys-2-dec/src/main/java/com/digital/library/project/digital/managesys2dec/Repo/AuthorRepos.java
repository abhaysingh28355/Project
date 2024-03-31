package com.digital.library.project.digital.managesys2dec.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digital.library.project.digital.managesys2dec.models.Author;
import com.digital.library.project.digital.managesys2dec.models.Book;

public interface AuthorRepos extends JpaRepository<Author, Integer>{

	@Query(value="Select b from Author b where b.email=:email")
	Author findAuthor(String email);
	
	@Query(value="Select b from Author b where b.email=:email and b.name:name")
	Author findAuthorByemailAndname(String email,String name);
}
