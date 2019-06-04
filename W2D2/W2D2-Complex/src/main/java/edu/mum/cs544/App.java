package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Doctor doctor = new Doctor();
		doctor.setDoctortype("surgery");
		doctor.setFirstname("fdoc");
		doctor.setLastname("lname");
		em.persist(doctor);
		Patient patient = new Patient();
	
		patient.setName("Nobody");
		patient.setCity("FairField");
		patient.setStreet("burlington");
		patient.setZip("522788");
		em.persist(patient);
		Appointment app = new Appointment();
		app.setAppdate("2019-09-08");
		app.setDoctor(doctor);
		Payment payment = new Payment();
		payment.setAmount(100.0);
		payment.setPaydate("2019-09-08");
		app.setPayment(payment);
		app.setPatient(patient);
		em.persist(app);
		em.getTransaction().commit();
		em.close();
	}
}
