package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Book;

//@Component
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}