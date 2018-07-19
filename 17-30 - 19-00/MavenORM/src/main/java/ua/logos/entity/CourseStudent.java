package ua.logos.entity;

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
@Table(name = "course_student")
public class CourseStudent extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(name = "date_from")
	private String dateFrom;
	
	@Column(name = "date_to")
	private String dateTo;
	
}
