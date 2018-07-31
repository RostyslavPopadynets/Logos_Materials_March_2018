package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.entity.BookEntity;
import ua.logos.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	/*
		{
			"title": "Book title 1",
			"description": "Book description",
			"isbn": "wkfb378r2b37r",
			"price": 788.00,
			"author": "Author 1"
		}
	*/
	
	@PostMapping
	public ResponseEntity<Void> createBook(@RequestBody BookEntity bookEntity) {
		bookService.saveBook(bookEntity);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> bookEntities = bookService.findAllBooks();
		
		return new ResponseEntity<List<BookEntity>>
						(bookEntities, HttpStatus.OK);
	}
	
}
