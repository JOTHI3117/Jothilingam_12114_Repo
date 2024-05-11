package com.lms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.BorrowDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class BorrowImpl implements BorroeRepo {
	
	@Autowired
	EntityManager ema;

	@Override
	public List<BorrowDetails> findAllGenre() {
		Query query=ema.createQuery("from BorrowDetails");
		return query.getResultList();
	}

	@Override
	public boolean deleteById(int borrowId) {
		BorrowDetails obj=ema.find(BorrowDetails.class,borrowId);
        ema.remove(obj);
		return true;
	}

	@Override
	public BorrowDetails save(BorrowDetails borrow) {
		ema.persist(borrow);
		return borrow;
	}

}
