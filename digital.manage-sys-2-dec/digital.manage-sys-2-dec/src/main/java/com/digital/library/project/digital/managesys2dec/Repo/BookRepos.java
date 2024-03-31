package com.digital.library.project.digital.managesys2dec.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.library.project.digital.managesys2dec.models.Book;

public interface BookRepos extends JpaRepository<Book, Integer>{

}
