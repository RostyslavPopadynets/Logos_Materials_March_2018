package ua.logos.service.impl;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.BookDTO;
import ua.logos.entity.BookEntity;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;

// @Component
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void saveBook(BookDTO dto) {
		BookEntity book = new BookEntity();
		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getIsbn());
		book.setPrice(dto.getPrice());
		book.setDescription(dto.getDescription());
		book.setAuthor(dto.getAuthor());
		
		bookRepository.save(book);
	}

	@Override
	public BookDTO findBookById(Long id) {
		BookEntity entity = bookRepository.findById(id).get();
		BookDTO dto = new BookDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setIsbn(entity.getIsbn());
		dto.setPrice(entity.getPrice());
		dto.setAuthor(entity.getAuthor());
		
		return dto;
	}

	@Override
	public List<BookDTO> findAllBooks() {
		return null;
	}

	@Override
	public void deleteBook(Long id) {

	}

}
