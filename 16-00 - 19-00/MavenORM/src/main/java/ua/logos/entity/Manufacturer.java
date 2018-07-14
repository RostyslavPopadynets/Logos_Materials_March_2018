package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "manufacturer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "models")
public class Manufacturer extends BaseEntity {
	
	@Column(name = "name", length = 100, unique = true, nullable = false)
	private String name;
	
	@Column(name = "short_name", length = 15, nullable = false)
	private String shortName;
	
	@OneToMany(mappedBy = "manufacturer")
	private List<Model> models;
	
}
