package com.zavada.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "books")

@Entity
@Table(name = "authors", indexes = @Index(columnList = "lastName, email"))
public class AuthorEntity extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String authorId;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String imageUrl;
	
	private LocalDate dateOfBirth; // format is 2007-12-03
	
	@ManyToMany(mappedBy = "authors")
	@JsonBackReference
	private List<BookEntity> books = new ArrayList<>();
	
}
