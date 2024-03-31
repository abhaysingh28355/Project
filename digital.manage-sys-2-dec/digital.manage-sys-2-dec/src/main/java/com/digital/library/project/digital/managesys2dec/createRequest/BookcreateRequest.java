package com.digital.library.project.digital.managesys2dec.createRequest;

import com.digital.library.project.digital.managesys2dec.models.Author;
import com.digital.library.project.digital.managesys2dec.models.Book;
import com.digital.library.project.digital.managesys2dec.models.Genre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder

public class BookcreateRequest {

	@NotBlank
	private String name;
	
	@NotBlank
	private Genre genre;
	
	@NotBlank
	private String authorname;
	
	@NotBlank
	@Email
	private String email;
	
	public Book to() {
		Author author=author.builder().Authname(authorname).email(email).build();
		return Book.builder().name(name).genre(genre).myauthor(author).build();
	}
}
