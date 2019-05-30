package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");
		// Open a EntityManager
		// Retrieve all students from the database and display their names
		// important: your query needs to be: from edu.mum.cs544.Students
		// Close the EntityManager
		EntityManager em = emf.createEntityManager();
		TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
		query.getResultList().forEach(System.out::println);
		em.close();

		// Open a EntityManager
		// Add an extra student to the database (you can choose his / her name)
		// Close the EntityManager
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Students s = new Students();
		s.setName("DongWang");
		s.setEmail("dd@ww.com");
		s.setPassword("123");
		s.setId(987005);
		em.persist(s);
		em.getTransaction().commit();
		em.close();

		// Open a EntityManager
		// Retrieve all students again from the database and display their names
		// Close the EntityManager
		em = emf.createEntityManager();
		query = em.createQuery("from edu.mum.cs544.Students", Students.class);
		query.getResultList().forEach(System.out::println);
		em.close();
	}

}
