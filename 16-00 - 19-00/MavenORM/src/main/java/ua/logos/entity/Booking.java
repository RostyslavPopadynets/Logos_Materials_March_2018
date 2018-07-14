package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter @Setter
@NoArgsConstructor
public class Booking extends BaseEntity {

	@Column(name = "date_from")
	private String dateFrom;
	
	@Column(name = "date_to")
	private String dateTo;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerPerson;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "booking_status_id")
	private BookingStatus bookingStatus;
}
