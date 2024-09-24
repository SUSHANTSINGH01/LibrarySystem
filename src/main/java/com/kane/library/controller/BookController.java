package com.kane.library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import com.kane.library.service.BookService;
import com.kane.library.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("/issueBook")
	public String issueBook(Model model) {
		List<Book> books = bookService.listBooks();
		model.addAttribute("books", books);
		return "issueBook";
	}

	@GetMapping("/issueBookById")
	public ResponseEntity<String> issueBook(@RequestParam("id") int id) {
		return bookService.issueBookMethod(id);
	}

	@GetMapping("/returnBook")
	public String returnBook(Model model) {
		List<Book> books = bookService.listOfReturnBooks();
		model.addAttribute("books", books);
		return "returnBook";
	}

	@GetMapping("/returnBookById")
	public ResponseEntity<String> returnBook(@RequestParam("id") int id) {
		return bookService.returnBookMethod(id);
	}

	@GetMapping("/bookList")
	public String bookList(Model model) {
		List<Book> books = bookService.listBooks();
		model.addAttribute("books", books);
		return "bookList";
	}

	@GetMapping("/searchBook")
	public String searchBook(Model model) {
		List<Book> books = bookService.listBooks();
		model.addAttribute("books", books);
		return "searchBook";
	}

	@GetMapping("/searchBookByTitle")
	public ResponseEntity<Book> searchBook(@RequestParam("title") String title) {
		return bookService.getBookByTitleMethod(title);
	}

}
