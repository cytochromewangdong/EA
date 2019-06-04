package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Owner owner = new Owner();
		owner.setAddress("405 E Burlington Ave");
		owner.setName("Dong Wang");
		// Create new instance of Car and set values in it
		Car car1 = new Car("BMW", "SDA231", 30221.00);
		car1.setOwner(owner);
		// save the car
		em.persist(car1);
		// Create new instance of Car and set values in it
		Car car2 = new Car("Mercedes", "HOO100", 4088.00);
		// save the car
		em.persist(car2);
		car2.setOwner(owner);
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		// retieve all cars
		TypedQuery<Car> query = em.createQuery("from Car", Car.class);
		List<Car> carList = query.getResultList();
		for (Car car : carList) {
			System.out.println("brand= " + car.getBrand() + ", year= " + car.getYear() + ", price= " + car.getPrice());
			System.out.println("Owner: Id = " + car.getOwner().getId() + ", name= " + car.getOwner().getName()
					+ ", address= " + car.getOwner().getAddress());
		}
		em.getTransaction().commit();
		em.close();
	}
}
