package ua.airlines.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "country")
public class Country extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "country")
	private List<Destination> destinations;

}
