package com.lms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lms.model.Books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BooksImpl implements BooksRepo {

	@Autowired
	EntityManager entitymanager;

	@Override
	public List<String> finfByGenre() {
		Query query=entitymanager.createQuery("select genre from Books");
		return query.getResultList();
	}

	@Override
	public List<Books> findAll() {
		Query query=entitymanager.createQuery("from Books");
		return query.getResultList();
	}

	
	
}
