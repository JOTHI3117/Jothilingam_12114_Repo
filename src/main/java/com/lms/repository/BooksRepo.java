package com.lms.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.lms.model.Books;

@Repository
public interface BooksRepo  {

	public List<String> finfByGenre();
	
	public List<Books> findAll();
	
	

}
