package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", unique = true, length = 120, nullable = false)
	private String title;
	
	@Column(name = "description", columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
}
