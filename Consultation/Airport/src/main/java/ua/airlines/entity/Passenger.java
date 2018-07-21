package ua.airlines.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "passenger")
public class Passenger extends BaseEntity {

	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "passport_number", length = 15, nullable = false)
	private String passportNumber;
	
	@Column(name = "passport_given", length = 12, nullable = false)
	private String passportGiven;
	
}
