package com.zavada.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String categoryId;
	
	@Column(nullable = false)
	private String name;
	private String description;
}
