package ua.logos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.security.authentication.AuthenticationManager;
import ua.logos.entity.BookEntity;
import ua.logos.entity.CategoryEntity;
import ua.logos.repository.BookRepository;
import ua.logos.repository.CategoryRepository;

@SpringBootApplication
public class SpringBootRestServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contex = 
				SpringApplication.run(SpringBootRestServerApplication.class, args);
		addCategories(contex);
		addBooks(contex);
	}


	private static void addCategories(ConfigurableApplicationContext contex) {
		List<String> categories = new ArrayList<>();
		categories.add("Комедія");
		categories.add("Драма");
		categories.add("Біографія");
		categories.add("Детектив");
		categories.add("Містика");
		categories.add("Фентезі");
		
		CategoryRepository categoryRepository = 
				contex.getBean(CategoryRepository.class);
		
		if(categoryRepository.count() == 0) {
			categories.forEach(c -> {
				CategoryEntity category = new CategoryEntity();
				category.setName(c);
				categoryRepository.save(category);
			});
		}
	}
	
	private static void addBooks(ConfigurableApplicationContext contex) {
		BookRepository bookRepository = contex.getBean(BookRepository.class);
		
		if(bookRepository.count() == 0) {
			
			for(int i = 0; i <= 1000; i++) {
				BookEntity bookEntity = new BookEntity();
				bookEntity.setTitle("Book title - " + i);
				bookEntity.setDescription("Book descr - " + i);
				bookEntity.setIsbn("sdjns" + i + "dfjksd" + i);
				bookEntity.setPrice(new BigDecimal(i * 10 + ".00"));
				bookEntity.setAuthor("Author - " + i);
				
				CategoryEntity category = new CategoryEntity();
				if(i % 2 == 0) {
					category.setId(2L);
					bookEntity.setCategory(category);
				} else if(i % 2 == 1) {
					category.setId(5L);
					bookEntity.setCategory(category);
				} else {
					category.setId(3L);
					bookEntity.setCategory(category);
				}
				
				bookRepository.save(bookEntity);
			}
		}
	}	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
