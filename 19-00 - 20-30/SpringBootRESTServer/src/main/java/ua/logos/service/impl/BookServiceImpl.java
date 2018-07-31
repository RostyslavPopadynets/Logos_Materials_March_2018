package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.BookEntity;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;

// @Component
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void saveBook(BookEntity entity) {
		bookRepository.save(entity);
	}

	@Override
	public BookEntity findBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<BookEntity> findAllBooks() {
		return bookRepository.findAll();
	}

}
