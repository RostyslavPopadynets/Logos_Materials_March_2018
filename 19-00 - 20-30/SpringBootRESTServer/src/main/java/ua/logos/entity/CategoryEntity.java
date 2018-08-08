package ua.logos.entity;

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
@Table(name = "category", indexes = @Index(columnList = "name"))
public class CategoryEntity extends BaseEntity {

	private String name;
	
}
