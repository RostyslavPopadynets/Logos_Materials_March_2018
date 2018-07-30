package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.Book;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.getOne(id); // .findById(id).get()
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

}