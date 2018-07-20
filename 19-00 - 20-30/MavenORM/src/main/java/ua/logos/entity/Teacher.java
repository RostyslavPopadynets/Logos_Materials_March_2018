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

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 35)
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;

	@OneToOne
	@JoinColumn(name = "teacher_details_id")
	private TeacherDetails teacherDetails;

}
