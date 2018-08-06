package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
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
@Table(name = "book", indexes = @Index(columnList = "title, isbn"))
public class Book extends BaseEntity {
	
	@Column(name = "title")
	private String title;
	private String description;
	private BigDecimal price;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	private String isbn;
	private String author;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
