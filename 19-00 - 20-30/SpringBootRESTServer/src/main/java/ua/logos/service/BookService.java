package ua.logos.service;

import java.util.List;

import ua.logos.domain.BookDTO;

public interface BookService {

	void saveBook(BookDTO dto);
	
	BookDTO findBookById(Long id);
	
	List<BookDTO> findAllBooks();
	
	void deleteBook(Long id);
}
