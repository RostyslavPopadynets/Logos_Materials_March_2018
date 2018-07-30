package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.entity.Book;
import ua.logos.entity.BookDTO;
import ua.logos.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;

	/*
		{
			"title": "Book title 1",
			"description": "Book description ..... ",
			"price": 199.99,
			"imageUrl": "http://",
			"isbn": "sjkvnj4ruiu",
			"author": "Author 1"
		}
	*/
	@PostMapping // localhost:8080/books
	public ResponseEntity<Void> addBook(@RequestBody BookDTO book) {
		//bookService.saveBook(book);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<List<Book>> (books, HttpStatus.OK);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Long id) {
		Book book = bookService.findById(id);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
