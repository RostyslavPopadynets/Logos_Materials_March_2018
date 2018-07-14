package ua.logos.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter @Setter @NoArgsConstructor
public class Vehicle extends BaseEntity {
	
	@Column(name = "reg_number", length = 30, nullable = false, unique = true)
	private String regNumber;
	
	@Column(name = "current_milleage", nullable = false)
	private int currentMilleage;
	
	@Column(name = "hourly_rate", columnDefinition = "DECIMAL(6,2) DEFAULT 150.00")
	private BigDecimal hourlyRate;
	
	@Column(name = "engine_size", columnDefinition = "DECIMAL(2,1)")
	private BigDecimal engineSize;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_category_id")
	private VehicleCategory vehicleCategory;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Booking> bookings;

}
