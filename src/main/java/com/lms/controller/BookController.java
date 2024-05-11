package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Books;
import com.lms.repository.BooksImpl;
import com.lms.repository.BooksRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {

	@Autowired
	BooksRepo repo;

	@GetMapping("/getBookGenreList")
	public List<String> getBookGenreNameList() {
		List<String> list = repo.finfByGenre();
		return list;
	}

	@GetMapping("GetAllBookDetails")
	public List<Books> getAllBookDetails() {
		List<Books> st = repo.findAll();
		return st;
	}

}
