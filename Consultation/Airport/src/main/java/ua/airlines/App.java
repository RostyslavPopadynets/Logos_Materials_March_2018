package ua.airlines;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.airlines.entity.AirCompany;
import ua.airlines.entity.Country;
import ua.airlines.entity.Destination;
import ua.airlines.entity.Flight;
import ua.airlines.entity.Passenger;
import ua.airlines.entity.Plane;
import ua.airlines.entity.Ticket;
import ua.airlines.entity.enums.PlaneType;
import ua.airlines.entity.enums.SitsClass;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// addCountryAndCity(em);
		// addAirCompanyAndPlane(em);
		// addFlight(em);
		// addPassenger(em);
		// addTicket(em);
		
		System.err.println("Hello World");
		
		em.getTransaction().commit();

		em.close();
		factory.close();
	}

	private static void addCountryAndCity(EntityManager em) {
		Country country = new Country();
		country.setName("Ukraine");
		em.persist(country);

		Destination destination = new Destination();
		destination.setCity("Lviv");
		destination.setCountry(country);
		em.persist(destination);

		destination = new Destination();
		destination.setCity("Kyiv");
		destination.setCountry(country);
		em.persist(destination);
	}

	private static void addAirCompanyAndPlane(EntityManager em) {
		AirCompany airCompany = new AirCompany();
		airCompany.setCompanyName("WizzAir");
		airCompany.setCompanyAddress("WizzAir street 12");
		em.persist(airCompany);

		Plane plane = new Plane();
		plane.setAirCompany(airCompany);
		plane.setPlaneType(PlaneType.BOEING_777_180);
		em.persist(plane);

		plane = new Plane();
		plane.setAirCompany(airCompany);
		plane.setPlaneType(PlaneType.AIRBUS_A220_190);
		em.persist(plane);
	}

	private static void addFlight(EntityManager em) {
		Plane plane = em.createQuery("SELECT p FROM Plane p WHERE p.id = :planeId", Plane.class)
				.setParameter("planeId", 2L).getSingleResult();

		Destination destination = em.createQuery("SELECT d FROM Destination d WHERE d.id = :dId", Destination.class)
				.setParameter("dId", 1L).getSingleResult();

		Flight flight = new Flight();
		flight.setDestination(destination);
		flight.setPlane(plane);
		flight.setDepartureTime("2018-08-04 12:00");
		flight.setArrivalTime("2018-08-04 19:15");
		flight.setTravelTime("07:15");
		em.persist(flight);
	}

	private static void addPassenger(EntityManager em) {
		Passenger passenger = new Passenger();
		passenger.setFirstName("John");
		passenger.setLastName("Doe");
		passenger.setPassportNumber("AA00000");
		passenger.setPassportGiven("2008-12-12");
		em.persist(passenger);

		passenger = new Passenger();
		passenger.setFirstName("Tom");
		passenger.setLastName("Thompson");
		passenger.setPassportNumber("BB00000");
		passenger.setPassportGiven("2012-12-12");
		em.persist(passenger);
	}

	private static void addTicket(EntityManager em) {
		Flight flight = em.createQuery("SELECT f FROM Flight f WHERE f.id = :fId", Flight.class).setParameter("fId", 1L)
				.getSingleResult();

		Passenger passenger = em.createQuery("SELECT p FROM Passenger p WHERE p.id = :pId", Passenger.class)
				.setParameter("pId", 1L).getSingleResult();

		Ticket ticket = new Ticket();
		ticket.setFlight(flight);
		ticket.setPassenger(passenger);
		ticket.setPrice(new BigDecimal("400.00"));
		ticket.setSitsClass(SitsClass.ECONOMY);
		ticket.setSeat("A20");
		ticket.setDepatrureDate(flight.getDepartureTime());
		ticket.setArrivalDate(flight.getArrivalTime());
		em.persist(ticket);

	}
}
