package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Column(name = "full_name", length = 100, nullable = false)
	private String fullName;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	private int age;
}
