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
		
		School school = new School();
		school.setName("Maharish University");
		em.persist(school);
		Student s1 = new Student();
		s1.setStudentid(1L);
		s1.setFirstname("Dong");
		s1.setLastname("Wang");
		em.persist(s1);
		school.getStudents().put(s1.getStudentid(), s1);
		
		Student s2 = new Student();
		s2.setStudentid(2L);
		s2.setFirstname("ddd");
		s2.setLastname("www");
		em.persist(s2);
		school.getStudents().put(s2.getStudentid(), s2);
		em.getTransaction().commit();
		em.close();
	}
}
