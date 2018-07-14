package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "model")
@Getter @Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Model extends BaseEntity {

	@Column(name = "name", length = 80, nullable = false)
	private String name;
	
	@Column(name = "year", nullable = false)
	private String year;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;
	
}
