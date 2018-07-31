package ua.logos.service;

import java.util.List;

import ua.logos.entity.BookEntity;

public interface BookService {

	void saveBook(BookEntity entity);
	
	BookEntity findBookById(Long id);
	
	List<BookEntity> findAllBooks();
}
