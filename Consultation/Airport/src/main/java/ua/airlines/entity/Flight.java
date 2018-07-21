package ua.airlines.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "flight")
public class Flight extends BaseEntity {

	@Column(name = "departure_time", length = 20)
	private String departureTime;
	
	@Column(name = "travel_time", length = 8)
	private String travelTime;
	
	@Column(name = "arrival_time", length = 20)
	private String arrivalTime;
	
	@ManyToOne
	@JoinColumn(name = "plane_id", nullable = false)
	private Plane plane;
	
	@ManyToOne
	@JoinColumn(name = "destination_id", nullable = false)
	private Destination destination;
}
