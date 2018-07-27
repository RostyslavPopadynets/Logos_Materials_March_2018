package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "book")
public class Book extends BaseEntity {
	private String title;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private String isbn;
	private String author;
}
