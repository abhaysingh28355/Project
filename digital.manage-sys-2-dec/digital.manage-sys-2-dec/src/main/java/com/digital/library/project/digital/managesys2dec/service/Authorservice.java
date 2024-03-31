package com.digital.library.project.digital.managesys2dec.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.library.project.digital.managesys2dec.Repo.AuthorRepos;
import com.digital.library.project.digital.managesys2dec.models.Author;

@Service
public class Authorservice {
	
	@Autowired
	
	AuthorRepos authorRepos;

	public static Author createorGetAuthor(Object myAuthor) {
		// TODO Auto-generated method stub
		Author authorFromDB;
		
			authorFromDB = AuthorRepos.findAuthor( myAuthor.getEmail());
		
		if(authorFromDB==null) {
			authorFromDB=AuthorRepos.save(myAuthor);
		}
		return authorFromDB;
	}

}
