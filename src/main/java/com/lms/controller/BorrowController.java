package com.lms.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.BorrowDetails;
import com.lms.repository.BorroeRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class BorrowController {

	@Autowired
	BorroeRepo repo;

	@PostMapping("/AddBorrow")
	public String createBorrow(@RequestBody BorrowDetails borrow) {

		String msg = " ";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate date = LocalDate.now();
			String curDate = date.format(formatter).toString();

			String returnDate = date.plusDays(8).format(formatter).toString();

			borrow.setBorrowDate(curDate);
			borrow.setReturnDate(returnDate);

//			borrow.setBooks(borrow.getBooks());
//			borrow.setUser(borrow.getUser());

			System.out.println(borrow);
			repo.save(borrow);
			msg = "User Object Saved";
		} catch (Exception e) {
			System.out.println(e);
			msg = "User Object Not Saved";
		}
		return msg;
	}

	@GetMapping("GetAllBorrow")
	public List<BorrowDetails> getAllBorrowDetails() {
		List<BorrowDetails> st = repo.findAllGenre();
		return st;
	}

	@DeleteMapping("deleteBorrowId/{borrowId}")
	public boolean deleteUser(@PathVariable("borrowId") int borrowId) {

		try {
			repo.deleteById(borrowId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
