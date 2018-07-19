package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "teacher")
@ToString(callSuper = true, exclude = {"teacherDetails", "courses"})
public class Teacher extends BaseEntity {

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "age")
	private int age;
	
	@OneToOne
	@JoinColumn(name = "teacher_details_id")
	private TeacherDetails teacherDetails;
	
	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
}
