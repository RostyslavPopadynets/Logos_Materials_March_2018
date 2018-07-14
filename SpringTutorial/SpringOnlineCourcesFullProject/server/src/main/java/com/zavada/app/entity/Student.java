package com.zavada.app.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	@Column(name = "full_name", length = 120, nullable = false)
	private String fullName;
	
	@Column(name = "email", length = 80, nullable = false, unique = true)
	private String email;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@OneToMany(mappedBy = "student")
	private List<StudentCource> studentCources;
	
}
