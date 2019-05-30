package edu.mum.cs544;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppBook {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");
		// Open a EntityManager
		// Create 3 books save them to the database
		// Close the EntityManager
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Book bk = new Book();
		bk.setAuthor("Dong Wang1");
		bk.setISBN("1111");
		bk.setPrice(100.8);
		bk.setPublishDate(new Date());
		bk.setTitle("Go with flow");
		em.persist(bk);

		bk = new Book();
		bk.setAuthor("Author1");
		bk.setISBN("2222");
		bk.setPrice(98.8);
		bk.setPublishDate(new Date());
		bk.setTitle("Parallel space");
		em.persist(bk);

		bk = new Book();
		bk.setAuthor("Author2");
		bk.setISBN("33333333");
		bk.setPrice(198.8);
		bk.setPublishDate(new Date());
		bk.setTitle("Magic earth");
		em.persist(bk);

		em.getTransaction().commit();
		em.close();
		// Open a EntityManager
		// Retrieve all books and output them to the console
		// Close the EntityManager
		em = emf.createEntityManager();
		TypedQuery<Book> typedQuery = em.createQuery("from Book", Book.class);
		List<Book> resultList = typedQuery.getResultList();
		resultList.forEach(System.out::println);
		em.close();
		// Open a EntityManager
		// Retrieve all books from the database, and then:
		// Change the title and price of one book
		// Use em.remove() to delete a different book (not the one that was just
		// updated)
		// Close the EntityManager
		em = emf.createEntityManager();
		em.getTransaction().begin();
		typedQuery = em.createQuery("from Book", Book.class);
		resultList = typedQuery.getResultList();
		resultList.get(0).setTitle("-----Changed title");
		em.remove(resultList.get(1));
		em.getTransaction().commit();
		em.close();
		// Open a EntityManager
		// Retrieve all books and output them to the console
		// Close the EntityManager
		em = emf.createEntityManager();
		typedQuery = em.createQuery("from Book", Book.class);
		resultList = typedQuery.getResultList();
		resultList.forEach(System.out::println);
		em.close();
	}

}
