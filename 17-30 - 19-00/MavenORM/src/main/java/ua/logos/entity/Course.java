package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name = "course")
public class Course extends BaseEntity {

	@Column(name = "title", unique = true, nullable = false, length = 120)
	private String title;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "price", columnDefinition = "decimal(5,2)")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

}
