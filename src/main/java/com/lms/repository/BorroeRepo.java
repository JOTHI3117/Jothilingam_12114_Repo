package com.lms.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.model.BorrowDetails;


public interface BorroeRepo {

	public List<BorrowDetails> findAllGenre();

	public boolean deleteById(int borrowId);

	public BorrowDetails save(BorrowDetails borrow);

}
