package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "student")
public class Student extends BaseEntity {
	
	@Column(name = "full_name", length = 130, nullable = false)
	private String fullName;
	
	@Column(length = 80, nullable = false, unique = true)
	private String email;
	
	@ManyToMany(mappedBy = "students")
	private List<Course> courses;
}
