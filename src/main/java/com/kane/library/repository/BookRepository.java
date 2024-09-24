package com.kane.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kane.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByTitle(String title);
	Book findById(int id);
	List<Book> findAllByOrderByIdAsc();
	List<Book> findByAvailableFalseOrderByIdAsc();
}