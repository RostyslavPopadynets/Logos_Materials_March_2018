package ua.logos.service.impl;

import java.awt.print.Book;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.logos.domain.BookDTO;
import ua.logos.entity.BookEntity;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;
import ua.logos.service.utils.ObjectMapperUtils;

// @Component
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveBook(BookDTO dto) {
		// BookEntity book = new BookEntity();
		// book.setTitle(dto.getTitle());
		// book.setIsbn(dto.getIsbn());
		// book.setPrice(dto.getPrice());
		// book.setDescription(dto.getDescription());
		// book.setAuthor(dto.getAuthor());

		BookEntity book = modelMapper.map(dto, BookEntity.class);
		bookRepository.save(book);
	}

	@Override
	public BookDTO findBookById(Long id) {
		// BookDTO dto = new BookDTO();
		// dto.setId(entity.getId());
		// dto.setTitle(entity.getTitle());
		// dto.setDescription(entity.getDescription());
		// dto.setIsbn(entity.getIsbn());
		// dto.setPrice(entity.getPrice());
		// dto.setAuthor(entity.getAuthor());

		// return modelMapper.map(bookRepository.findById(id).get(), BookDTO.class);
		BookEntity entity = bookRepository.findById(id).get();
		BookDTO bookDTO = modelMapper.map(entity, BookDTO.class);
		return bookDTO;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<BookDTO> findAllBooks() {
		List<BookEntity> bookEntities = bookRepository.findAll();
		List<BookDTO> bookDTOs = modelMapper.mapAll(bookEntities, BookDTO.class);
		return bookDTOs;
	}

	@Override
	public List<BookDTO> findAllBooksByCategoryId(Long id) {
		List<BookEntity> bookEntities = bookRepository.findAllBooksByCategoryId(id);

		List<BookDTO> bookDTOs = modelMapper.mapAll(bookEntities, BookDTO.class);

		return bookDTOs;
	}

	@Override
	public List<BookDTO> findAllBooks(Pageable pageable) {
		// Page number
		// Size
		Page<BookEntity> booksPage = bookRepository
				.findAll(
						PageRequest.of(
								pageable.getPageNumber(), 
								pageable.getPageSize(),
								pageable.getSort()
							)
						);
		
		List<BookEntity> bookEntities = booksPage.getContent();
		List<BookDTO> bookDTOs = 
				modelMapper.mapAll(bookEntities, BookDTO.class);
		
		return bookDTOs;
		/*return modelMapper.mapAll(bookRepository.findAll(PageRequest.of(
								pageable.getPageNumber(), 
								pageable.getPageSize())
						).getContent(), BookDTO.class)*/
	}

}
