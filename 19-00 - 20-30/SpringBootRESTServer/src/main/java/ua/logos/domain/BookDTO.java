package ua.logos.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private Long id;
	private String title;
	private String description;
	private String isbn;
	private BigDecimal price;
	private String author;
	private CategoryDTO category;
}