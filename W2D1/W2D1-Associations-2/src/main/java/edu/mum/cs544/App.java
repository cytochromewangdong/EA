package edu.mum.cs544;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// a) Create a Bidirectional OneToMany association between Department and
		// Employee
		// using annotations.
		// f) Create a Bidirectional ManyToOne association between Employee and Office
		// using
		// annotations.
		Department dpt = new Department();
		dpt.setName("Compro");
		Office office = new Office();
		office.setBuilding("Mclauphin");
		office.setRoomnumber("208");

		Employee e1 = new Employee();
		e1.setName("A");
		e1.setEmployeenumber(1001L);
		e1.register(dpt, office);
		em.persist(e1);
		Employee e2 = new Employee();
		e2.setName("B");
		e2.setEmployeenumber(1002L);
		e2.register(dpt, office);
		em.persist(e2);
		Employee e3 = new Employee();
		e3.setName("C");
		e3.setEmployeenumber(1003L);
		e3.register(dpt, office);
		em.persist(e3);

		em.persist(dpt);
		em.persist(office);

		// Create an Optional Unidirectional ManyToOne association between Book and
		// Publisher using annotations and without using NULL fields in the database
		Book bk = new Book();
		bk.setIsbn("i001");
		bk.setAuthor("Dong Wang");
		bk.setTitle("Don't know what happened");

		em.persist(bk);
		Book bk2 = new Book();
		bk2.setIsbn("i008");
		bk2.setAuthor("Ddd 888");
		bk2.setTitle("Another book");

		em.persist(bk2);
		Publisher pb = new Publisher();
		pb.setName("publisher001");
		em.persist(pb);
		bk.setPublisher(pb);
		bk2.setPublisher(pb);
		// c) Create a Bidirectional ManyToMany association between Student and Course
		// using
		// annotations. Be sure to make studentid values application assigned (not
		// generated)!
		Course course = new Course();
		course.setCoursenumber("C544");
		course.setName("EA");
		em.persist(course);

		Course course2 = new Course();
		course2.setCoursenumber("C588");
		course2.setName("EA88");
		em.persist(course2);

		Student s1 = new Student();
		s1.setFirstname("don1");
		s1.setLastname("Wan1");
		s1.setStudentid(987005L);
		s1.addCourse(course);
		s1.addCourse(course2);
		em.persist(s1);

		Student s2 = new Student();
		s2.setFirstname("don2");
		s2.setLastname("Wan2");
		s2.setStudentid(987008L);
		s2.addCourse(course);
		s2.addCourse(course2);
		em.persist(s2);

		// d) Create a Unidirectional OneToMany association between Customer and
		// Reservation
		// using annotations
		// e) Create a Unidirectional ManyToOne association between Reservation and Book
		// using
		// annotations.
		Customer cs = new Customer();
		cs.setName("customer1");
		Reservation rv = new Reservation();
		rv.setDate(new Date());
		rv.setBook(bk);
		cs.addReservation(rv);
		Reservation rv2 = new Reservation();
		rv2.setDate(new Date());
		rv2.setBook(bk);
		cs.addReservation(rv2);

		Reservation rv3 = new Reservation();
		rv3.setDate(new Date());
		rv3.setBook(bk);
		cs.addReservation(rv2);
		em.persist(cs);

		em.getTransaction().commit();
		em.close();
	}
}
