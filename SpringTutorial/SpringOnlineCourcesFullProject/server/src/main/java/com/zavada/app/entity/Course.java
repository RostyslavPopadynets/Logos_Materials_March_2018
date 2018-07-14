package com.zavada.app.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "course")
public class Course extends BaseEntity {

	@Column(name = "title", length = 100, nullable = false, unique = true)
	private String title;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0.00")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false, foreignKey = @ForeignKey(name = "teacher_fk"))
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course")
	private List<StudentCource> courseStudents;
	
}
