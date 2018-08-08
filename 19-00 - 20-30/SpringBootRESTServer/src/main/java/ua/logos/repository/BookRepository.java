package ua.logos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.logos.entity.BookEntity;

@Repository
public interface BookRepository 
	extends JpaRepository<BookEntity, Long> {
	
	@Query("SELECT b FROM BookEntity b WHERE b.category.id = :categoryId")
	List<BookEntity> findAllBooksByCategoryId(@Param("categoryId") Long id);
	
	@Query("SELECT b FROM BookEntity b WHERE b.isbn = :isbn")
	BookEntity findByBookIsbn(@Param("isbn") String isbn);
	
//	List<BookEntity> findByCategoryId(Long id);
//	
//	BookEntity findByIsbn(String isbn);
}
