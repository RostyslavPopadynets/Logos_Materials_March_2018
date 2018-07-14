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
@Table(name = "booking_status")
@Getter @Setter 
@NoArgsConstructor
public class BookingStatus extends BaseEntity {

	@Column(length = 30, nullable = false, unique = true)
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy = "bookingStatus")
	private List<Booking> bookings;
	
}
