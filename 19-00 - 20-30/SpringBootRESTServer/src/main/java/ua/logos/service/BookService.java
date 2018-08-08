package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import ua.logos.domain.BookDTO;

public interface BookService {

	void saveBook(BookDTO dto);
	
	BookDTO findBookById(Long id);
	
	List<BookDTO> findAllBooks();
	
	void deleteBook(Long id);
	
	List<BookDTO> findAllBooksByCategoryId(Long id);
	
	List<BookDTO> findAllBooks(Pageable pageable);
}
