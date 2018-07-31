package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.BookDTO;
import ua.logos.entity.Book;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;
import ua.logos.service.utils.ObjectMapperUtils;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;

//	@Autowired
//	private ModelMapper modelMapper;	
	
	@Override
	public void saveBook(BookDTO bookDto) {
//		Book bookEntity = new Book();
//		bookEntity.setTitle(bookDto.getTitle());
//		bookEntity.setDescription(bookDto.getDescription());
//		bookEntity.setPrice(bookDto.getPrice());
//		bookEntity.setAuthor(bookDto.getAuthor());
//		bookEntity.setIsbn(bookDto.getIsbn());
//		bookEntity.setImageUrl(bookDto.getImageUrl());
		
		Book bookEntity = modelMapper.map(bookDto, Book.class);
		bookRepository.save(bookEntity);
	}

	@Override
	public BookDTO findById(Long id) {
		Book bookEntity = bookRepository.findById(id).get();
		BookDTO bookDTO = modelMapper.map(bookEntity, BookDTO.class);
		return bookDTO;
	}

	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> bookDTOs = modelMapper.mapAll(books, BookDTO.class);
		return bookDTOs;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
