package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.logos.domain.BookDTO;
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
	public ResponseEntity<Void> createBook(@RequestBody BookDTO dto) {
		bookService.saveBook(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDTO> getBookById(
			@PathVariable("bookId") Long id) {
		
		BookDTO dto = bookService.findBookById(id);
		return new ResponseEntity<BookDTO>(dto, HttpStatus.OK);
	}
	
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Void> updateBook(
			@PathVariable("bookId") Long id, 
			@RequestBody BookDTO bookDTO) {
		
		BookDTO bookDTOFromDB = bookService.findBookById(id);
		
		if(bookDTOFromDB != null) {
			bookDTO.setId(id);
			bookService.saveBook(bookDTO);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long id) {
		
		BookDTO bookDTO = bookService.findBookById(id);
		if(bookDTO != null) {
			bookService.deleteBook(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		List<BookDTO> bookDTOs = bookService.findAllBooks();
		return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
	}
	
}