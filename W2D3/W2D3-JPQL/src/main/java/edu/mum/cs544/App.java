package edu.mum.cs544;

import java.util.List;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;
import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// a) Flights leaving USA capacity > 500
		System.out.println("Question A:");
		// List<Flight> flights = em.createQuery("from Flight ",
		// Flight.class).getResultList();
		TypedQuery<Flight> fQuery = em.createQuery(
				"select f from Flight f " + "join f.airplane a " + "join f.origin o " + "join f.destination d "
						+ "where a.capacity>:capacity " + "and o.country=:country " + "and d.country<>:country",
				Flight.class);
		fQuery.setParameter("capacity", 500);
		fQuery.setParameter("country", "USA");
		List<Flight> flights = fQuery.getResultList();
		System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
		for (Flight flight : flights) {
			System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(),
					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime());
		}
		System.out.println();

		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		// b) All airlines that use A380 airplanes
		System.out.println("Question B:");
		List<Airline> airlines = em
				.createQuery("select distinct a from Airline a"
						+ " join a.flights f "
						+ " join f.airplane p "
						+ " where p.model='A380'",
						Airline.class)
				.getResultList();
		System.out.println("Airlines that use A380s:");
		for (Airline airline : airlines) {
			System.out.println(airline.getName());
		}
		System.out.println();

		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		// c) Flights using 747 planes that don't belong to Star Alliance
		System.out.println("Question C:");
		flights = em.createQuery("select f from Flight f"
				+ " join f.airplane p"
				+ " join f.airline l"
				+ " where p.model='747' "
				+ " and l.name<>'Star Alliance'", Flight.class).getResultList();
		System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
		for (Flight flight : flights) {
			System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(),
					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime());
		}
		System.out.println();

		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);

		// d) All flights leaving before 12pm on 08/07/2009
		System.out.println("Question D:");
		TypedQuery<Flight> query = em.createQuery("select f from Flight f where (f.departureDate='2009-08-07' and f.departureTime<='12:00:00')", Flight.class);
		flights = query.getResultList();
		System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
		for (Flight flight : flights) {
			System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n", flight.getFlightnr(),
					flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
					flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime());
		}
		System.out.println();
		em.getTransaction().commit();
		em.close();
	}
}
