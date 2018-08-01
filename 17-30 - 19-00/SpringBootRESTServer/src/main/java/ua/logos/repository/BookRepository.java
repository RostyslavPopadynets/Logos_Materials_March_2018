package ua.logos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Book;

//@Component
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//	@Query("SELECT b FROM Book b WHERE b.category.id = :categoryId")
//	List<Book> findBookByCategoryId(@Param("categoryId") Long catId);
	
	List<Book> findByCategoryId(Long id);
	
	
}
