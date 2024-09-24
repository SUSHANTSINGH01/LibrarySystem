package com.kane.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.kane.library.model.Book;
import com.kane.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public ResponseEntity<String> issueBookMethod(int bookId) {
		Book book = bookRepository.findById(bookId);
		book.setAvailable(false);
		bookRepository.save(book);
		return ResponseEntity.ok("Book issued successfully: " + book.getTitle());
	}

	public ResponseEntity<String> returnBookMethod(int bookId) {
		Book book = bookRepository.findById(bookId);
		book.setAvailable(false);
		bookRepository.save(book);
		return ResponseEntity.ok("Book returned successfully: " + book.getTitle());
	}

	public List<Book> listBooks() {
		return bookRepository.findAllByOrderByIdAsc();
	}

	public List<Book> listOfReturnBooks() {
		return bookRepository.findByAvailableFalseOrderByIdAsc();
	}

	public ResponseEntity<Book> getBookByTitleMethod(String title) {
		Book book = bookRepository.findByTitle(title);
		if (book != null) {
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
