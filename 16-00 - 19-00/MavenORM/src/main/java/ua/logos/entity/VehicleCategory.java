package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle_category")
@Getter @Setter @NoArgsConstructor
public class VehicleCategory extends BaseEntity {

	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy = "vehicleCategory")
	private List<Vehicle> vehicles;
	
}
