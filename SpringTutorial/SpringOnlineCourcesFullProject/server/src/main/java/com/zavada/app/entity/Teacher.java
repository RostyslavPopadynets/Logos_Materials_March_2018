package com.zavada.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teacherId")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	@Column(name = "teacher_id", length = 50, nullable = false, unique = true)
	private String teacherId;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(name = "email", length = 80, nullable = false, unique = true)
	private String email;

	@Column(name = "age")
	private int age;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;

	// private boolean deleted;
}
