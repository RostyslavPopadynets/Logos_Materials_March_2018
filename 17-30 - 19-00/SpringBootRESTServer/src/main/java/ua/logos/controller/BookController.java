package ua.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.domain.BookDTO;
import ua.logos.domain.BookUpload;
import ua.logos.domain.filter.SimpleFilter;
import ua.logos.entity.Book;
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
//	@PostMapping // localhost:8080/books
//	public ResponseEntity<Void> addBook(@RequestBody Book book) {
//		bookService.saveBook(book);
//		
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<Book>> getBooks() {
//		List<Book> books = bookService.findAllBooks();
//		return new ResponseEntity<List<Book>> (books, HttpStatus.OK);
//	}
//	
//	@GetMapping("/{bookId}")
//	public ResponseEntity<Book> getBook(@PathVariable("bookId") Long id) {
//		Book book = bookService.findById(id);
//		
//		return new ResponseEntity<Book>(book, HttpStatus.OK);
//	}
	
	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
		bookService.saveBook(bookDTO);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("bookId") Long id) {
		BookDTO bookDTO = bookService.findById(id);
		return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<BookDTO>> getBooks() {
		List<BookDTO> bookDTOs = bookService.findAllBooks();
		return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long id, @RequestBody BookDTO bookDTO) {
		BookDTO book = bookService.findById(id);
		if(book != null) {
			bookDTO.setId(id);
			bookService.saveBook(bookDTO);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long id) {
		BookDTO book = bookService.findById(id);
		if(book != null) {
			bookService.deleteBook(book.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<BookDTO>> findBooksByCategoryId(
			@PathVariable("categoryId") Long id,
			@RequestParam("title") String name) {
		
		System.out.println(name);
		
		List<BookDTO> bookDTOs = bookService.findBookByCategoryId(id);
		
		return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/pages")
	public ResponseEntity<List<BookDTO>> findBooksByPage(
			@PageableDefault Pageable pageable) {
		List<BookDTO> bookDTOs = bookService.findAllBooksByPages(pageable);	
		return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<BookDTO>> findAllBooksBySearch(
//			@RequestParam(value = "search", required = false) String search
			SimpleFilter filter
			) {
//		SimpleFilter filter = new SimpleFilter();
//		filter.setSearch(search);
		
		List<BookDTO> bookDTOs = bookService.findAllBooksBySpecification(filter);
		
		return new ResponseEntity<List<BookDTO>>(bookDTOs, HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println("File: " + file.getOriginalFilename());
		bookService.saveFile(file);
		
		return new ResponseEntity<String>("File upload success.", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/upload/object")				// @ModelAttribute
	public ResponseEntity<String> uploadObjectFile(BookUpload bookUpload) {
		System.out.println("File: " + bookUpload.getFile().getOriginalFilename());
		bookService.saveFile(bookUpload.getFile());
		
		BookDTO book = new BookDTO();
		book.setTitle(bookUpload.getTitle());
		book.setPrice(bookUpload.getPrice());
		book.setImageUrl(bookUpload.getFile().getOriginalFilename());
		bookService.saveBook(book);
		
		return new ResponseEntity<String>("File upload success.", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/file")
	public ResponseEntity<String> getFile(@RequestParam("fileName") String name) {
		String fileBase64 = bookService.getFile(name);
		return new ResponseEntity<String>(fileBase64, HttpStatus.OK);
	}
	
}
