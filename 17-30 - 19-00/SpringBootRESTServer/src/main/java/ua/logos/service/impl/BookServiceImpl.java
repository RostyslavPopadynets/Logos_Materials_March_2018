package ua.logos.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.domain.BookDTO;
import ua.logos.domain.filter.SimpleFilter;
import ua.logos.entity.Book;
import ua.logos.repository.BookRepository;
import ua.logos.service.BookService;
import ua.logos.service.utils.CustomFileUtils;
import ua.logos.service.utils.ObjectMapperUtils;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;

	@Autowired
	private CustomFileUtils fileUtils;

	@Override
	public void saveBook(BookDTO bookDto) {
		// Book bookEntity = new Book();
		// bookEntity.setTitle(bookDto.getTitle());
		// bookEntity.setDescription(bookDto.getDescription());
		// bookEntity.setPrice(bookDto.getPrice());
		// bookEntity.setAuthor(bookDto.getAuthor());
		// bookEntity.setIsbn(bookDto.getIsbn());
		// bookEntity.setImageUrl(bookDto.getImageUrl());

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

	@Override
	public List<BookDTO> findBookByCategoryId(Long id) {
		List<Book> books = bookRepository.findByCategoryId(id);
		List<BookDTO> bookDTOs = modelMapper.mapAll(books, BookDTO.class);

		return bookDTOs;
	}

	@Override
	public List<BookDTO> findAllBooksByPages(Pageable pageable) {

		Page<Book> booksPage = bookRepository
				.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()));
		List<Book> books = booksPage.getContent();
		List<BookDTO> bookDTOs = modelMapper.mapAll(books, BookDTO.class);

		return bookDTOs;
	}

	@Override
	public List<BookDTO> findAllBooksBySpecification(SimpleFilter filter) {
		return modelMapper.mapAll(bookRepository.findAll(getSpecification(filter)), BookDTO.class);
	}

	private Specification<Book> getSpecification(SimpleFilter filter) {

		return new Specification<Book>() {

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				if (filter.getSearch().isEmpty()) {
					return null;
				}

				Expression<String> searchByTitleExp = root.get("title");
				Predicate searchByTitlePredicate = criteriaBuilder.like(searchByTitleExp,
						"%" + filter.getSearch() + "%");

				Expression<String> searchByIsbnExp = root.get("isbn");
				Predicate searchByIsbnPredicate = criteriaBuilder.equal(searchByIsbnExp, filter.getSearch());

				Expression<BigDecimal> priceFromExp = root.get("price");
				Predicate priceFromPredicate = criteriaBuilder.greaterThanOrEqualTo(priceFromExp,
						new BigDecimal("1000"));

				return criteriaBuilder.or(searchByTitlePredicate, searchByIsbnPredicate);
				// SELECT b FROM Book b WHERE title LIKE '%erer%'
			}

		};
	}

	@Override
	public void saveFile(MultipartFile file) {
		try {
			fileUtils.saveUploadedFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFile(String fileName) {
		return fileUtils.getFile(fileName);
		
	}
}