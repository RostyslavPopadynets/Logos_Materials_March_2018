package ua.logos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.entity.enums.Gender;

@Entity
@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
@ToString
@Table(name = "customer")
public class Customer extends BaseEntity {

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "details", columnDefinition = "TEXT")
	private String details;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "phone_number", length = 15, nullable = false)
	private String phoneNumber;

	@Column(length = 100, nullable = false)
	private String address;

	@Column(length = 50, nullable = false)
	private String town;

	@Column(length = 50, nullable = false)
	private String country;
	
	@Column(name = "birth_day")
	private Date birthDate;
	
	@OneToMany(mappedBy = "customerPerson")
	private List<Booking> bookings;

}
