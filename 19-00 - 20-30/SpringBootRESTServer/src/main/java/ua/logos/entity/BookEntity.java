package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {
	private String title;
	private String description;
	private String isbn;
	private BigDecimal price;
	private String author;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
}
