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
		Product p = new Product();
		p.setName("Ground Beef");
		p.setDescription("It is made from beef");
		em.persist(p);
		Product p2 = new Product();
		p2.setName("Body Soap");
		p2.setDescription("It is specifically designed for body");
		em.persist(p2);

		Cd cd = new Cd();
		cd.setName("cd");
		cd.setDescription("this is a cd");
		cd.setArtist("a fake CD");
		em.persist(cd);

		Dvd dvd = new Dvd();
		dvd.setName("dvd");
		dvd.setDescription("It is a good dvd");
		dvd.setGenre("classic");
		em.persist(dvd);

		Book book = new Book();
		book.setName("book");
		book.setDescription("It is a good book");
		book.setTitle("Go with Flow");
		em.persist(book);

		OrderLine olcd = new OrderLine();
		olcd.setProduct(cd);
		olcd.setQuantity(1);

		OrderLine oldvd = new OrderLine();
		oldvd.setProduct(dvd);
		oldvd.setQuantity(3);

		OrderLine olbook = new OrderLine();
		olbook.setProduct(book);
		olbook.setQuantity(8);

		OrderLine ol1 = new OrderLine();
		ol1.setProduct(p);
		ol1.setQuantity(2);

		OrderLine ol2 = new OrderLine();
		ol2.setProduct(p2);
		ol2.setQuantity(5);

		Order order = new Order();
		order.setDate(new Date());
		order.getOrderLines().add(oldvd);
		order.getOrderLines().add(olcd);
		order.getOrderLines().add(ol1);
		order.getOrderLines().add(ol2);
		Customer cs = new Customer();
		cs.setFirstname("Dong");
		cs.setLastname("Wang");
		em.persist(cs);
		cs.addOrder(order);
		em.persist(order);
		em.getTransaction().commit();
		em.close();
	}
}
