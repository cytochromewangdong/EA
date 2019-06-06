package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	private final static EntityManagerFactory EMF;
	private final static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();
	static {
		EMF = Persistence.createEntityManagerFactory("cs544");
	}

	public static EntityManager getCurrent() {
		EntityManager em = threadLocal.get();
		if (em == null || !em.isOpen()) {
			em = EMF.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}

	public static void closeEntityManagerFactory() {
		EMF.close();
	}

}
