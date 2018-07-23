package ua.logos.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"teacher", "students"})

@Entity
@Table(name = "course")
public class Course extends BaseEntity {
	
	@Column(name = "title", unique = true, length = 120, nullable = false)
	private String title;
	
	@Column(name = "description", columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@ManyToMany// (fetch = FetchType.EAGER)
	@JoinTable(name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> students;
}
