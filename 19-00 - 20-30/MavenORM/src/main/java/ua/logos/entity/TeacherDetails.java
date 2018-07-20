package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teacher_details")
public class TeacherDetails extends BaseEntity {

	@Column(name = "hobby", length = 200, nullable = false)
	private String hobby;

	@Column(name = "image_url")
	private String imageUrl;

	@OneToOne(mappedBy = "teacherDetails")
	private Teacher teacher;
}
